package com.rnd.pc.service;

import java.io.File;
import java.util.Map;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import com.rnd.pc.db.DataAccessLayer;
import com.rnd.pc.model.Product;
import com.rnd.pc.model.ProductDBSingleton;
import com.rnd.pc.model.Service;
import com.rnd.pc.model.ServiceSpecification;
import com.rnd.pc.utils.PCUtils;

@Path("/prodcat")
public class ProductCatalogRestService {

	@GET
	@Path("/welcome/{name}")
	@Produces(MediaType.TEXT_HTML)
	public String printWelcome(@PathParam("name") String name) {

		return "Welcome " + name + "\n" + "Supported Operations : \n" + "1. Get all products --> \\listproducts";
	}

	@GET
	@Path("/productsgen")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllProductsResponse() {
		GenericEntity<Map<String, Product>> entity = new GenericEntity<Map<String, Product>>(
				ProductDBSingleton.getInstance().getProductMap()) {
		};
		return Response.ok(entity).build();
	}

	@DenyAll
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Product> getProducts() {
		return ProductDBSingleton.getInstance().getProductMap();
	}

	@RolesAllowed("Administrator")
	@GET
	@Path("/specs")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, ServiceSpecification> getSpec() {
		return ProductDBSingleton.getInstance().getSpecMap();
	}

	@GET
	@Path("/cfs")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Service> getCFService() {
		return ProductDBSingleton.getInstance().getCFServiceMap();
	}
	
	
	@GET
	@Path("/queryparam")
	@Produces(MediaType.TEXT_HTML)
	public Response testQueryParam(@QueryParam("id") int id, @QueryParam("password") String password) {
		return Response.ok("Query Param: ID = " + id + " Password = " + password).build();
	}
	
	@GET
	@Path("/matrixparam")
	@Produces(MediaType.TEXT_HTML)
	public Response testMatrixParam(@MatrixParam("id") int id, @MatrixParam("password") String password) {
		return Response.ok("Matrix Param: ID = " + id + " Password = " + password).build();
	}
	
	
	//Doesn't allow multiple headers with same name
	@GET
	@Path("/headerparam")
	@Produces(MediaType.TEXT_HTML)
	public Response testHeaderParam(@HeaderParam("empid") Integer id, @HeaderParam("dept") String dept) {
		return Response.ok("Query Param: Emp ID = " + id + " Password = " + dept).build();
	}
	
	
	//Automatically accepts multiple headers with same name
	@GET
	@Path("/headerparamviacontext")
	@Produces(MediaType.TEXT_HTML)
	public Response testHeaderParamViaContext(@Context HttpHeaders headers) {
		return Response.ok("Query Param: Emp ID = " + headers.getRequestHeader("empid") + " Password = " + headers.getRequestHeader("dept")).build();
	}
	
	
	@GET
	@Path("/download")
	@Produces("image/png")
	public Response testDownload() {
		File f = new File("d:\\server_file.png");
		ResponseBuilder response = Response.ok((Object) f);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.png");

		System.out.println("download method called");
		
		CacheControl cacheControl = new CacheControl();
		cacheControl.setMaxAge(3600);
		cacheControl.setPrivate(false);
		cacheControl.setNoTransform(false);
		
		return response.cacheControl(cacheControl).build();
	}
	

	@GET
	@Path("/rfs")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Service> getRFService() {
		return ProductDBSingleton.getInstance().getRFServiceMap();
	}

	@PUT
	@Path("/createspec/{quality}/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createSpec(@PathParam("quality") String serviceQuality, @PathParam("id") String specId) {
		ServiceSpecification spec = PCUtils.createSpec(serviceQuality, specId);
		ProductDBSingleton.getInstance().getSpecMap().put(specId, spec);

		DataAccessLayer accessLayer = new DataAccessLayer();
		accessLayer.setup();
		
		
		GenericEntity<ServiceSpecification> entity = new GenericEntity<ServiceSpecification>(spec) {
		};
		
		return Response.ok(entity).build();
		
	}

	@PUT
	@Path("/createservice/{serviceid}/{desc}/{type}/{specid}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_HTML })
	public Response createService(@PathParam("specid") String specId, @PathParam("serviceid") String serviceId,
			@PathParam("desc") String serviceDescription, @PathParam("type") String serviceType) {

		if (!"CFS".equalsIgnoreCase(serviceType) && !"RFS".equalsIgnoreCase(serviceType))
			return Response.status(Response.Status.EXPECTATION_FAILED).entity("Incorrect Service Type").build();

		ServiceSpecification specObject = ProductDBSingleton.getInstance().getSpecMap().get(specId);

		if (null == specObject)
			return Response.status(Response.Status.EXPECTATION_FAILED).entity("Specification Object with given specId not found").build();

		Service service = PCUtils.createService(specObject, serviceId, serviceDescription, serviceType);

		if ("CFS".equalsIgnoreCase(serviceType))
			ProductDBSingleton.getInstance().getCFServiceMap().put(serviceId, service);
		else
			ProductDBSingleton.getInstance().getRFServiceMap().put(serviceId, service);

		GenericEntity<Service> entity = new GenericEntity<Service>(service) {
		};
		return Response.ok(entity).build();

	}

	@PUT
	@Path("/createproduct/{pid}/{desc}/{cfsids}/{rfsids}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.TEXT_HTML })
	public Response createProduct(@PathParam("pid") String productId, @PathParam("desc") String productDescription,
			@PathParam("cfsids") String cfsids, @PathParam("rfsids") String rfsids) {

		String cfsidsArray[];
		String rfsidsArray[];
		Service[] cfSArray = null;
		Service[] rfSArray = null;

		if (null != cfsids) {
			cfsidsArray = cfsids.split(",");
			if (null != cfsidsArray) {
				cfSArray = new Service[cfsidsArray.length];
				for (int i = 0; i < cfsidsArray.length; i++) {
					cfSArray[i] = ProductDBSingleton.getInstance().getCFServiceMap().get(cfsidsArray[i]);
				}
			}
		}
		if (null != rfsids) {
			rfsidsArray = rfsids.split(",");
			if (null != rfsidsArray) {
				rfSArray = new Service[rfsidsArray.length];
				for (int i = 0; i < rfsidsArray.length; i++) {
					rfSArray[i] = ProductDBSingleton.getInstance().getRFServiceMap().get(rfsidsArray[i]);
				}

			}
		}

		Product product = PCUtils.createProduct(productId, productDescription, cfSArray, rfSArray);
		ProductDBSingleton.getInstance().getProductMap().put(productId, product);

		GenericEntity<Product> entity = new GenericEntity<Product>(product) {};
		return Response.ok(entity).build();

	}

}
