package com.nc.rnd.enums;

/**
 * Created by nirk0816 on 2/8/2017.
 */

//No need to put Abstract in the class definition, just define abstract method
public enum LoggerEnhancedAbstractEnum {

    DEBUG(10){
        @Override
        public void doAbstract() {
            System.out.println("Instantiated with abstract method value for DEBUG");
        }
    }
    , INFO(11){
        @Override
        public void doAbstract() {
            System.out.println("Instantiated with abstract method value for INFO");
        }
    }
    , ERROR(12){
        @Override
        public void doAbstract() {
            System.out.println("Instantiated with abstract method value for ERROR");
        }
    };

    int loggerIntValue;

    LoggerEnhancedAbstractEnum(int loggerIntValue)
            {
                this.loggerIntValue = loggerIntValue;
            }

    public int getValue()
    {
        return this.loggerIntValue;
    }


    @Override
    public String toString() {
        switch (this)
        {
            case DEBUG:
                return "You have selected DEBUG Logging Mode - Enhanced toString()";
            case INFO:
                return "You have selected INFO Logging Mode - Enhanced toString()";
            case ERROR:
                return "You have selected ERROR Logging Mode - Enhanced toString()";
        }
        return super.toString();
    }

    public abstract void doAbstract();
}
