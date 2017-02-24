package com.nc.rnd.enums;

/**
 * Created by nirk0816 on 2/8/2017.
 */
public enum LoggerEnhancedEnum {

    DEBUG(10), INFO(11), ERROR(12);

    int loggerIntValue;

    LoggerEnhancedEnum(int loggerIntValue)
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
}
