
package com.example.maitrinh.demoui_nexus4_nexus5.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("service_type")
    @Expose
    private String serviceType;
    @SerializedName("price1")
    @Expose
    private String price1;
    @SerializedName("price2")
    @Expose
    private String price2;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param serviceType
     * @param price2
     * @param price1
     */
    public Datum(Integer id, String name, String serviceType, String price1, String price2) {
        this.id = id;
        this.name = name;
        this.serviceType = serviceType;
        this.price1 = price1;
        this.price2 = price2;
    }

    /**
     * 
     * @return
     *     The id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The serviceType
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * 
     * @param serviceType
     *     The service_type
     */
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * 
     * @return
     *     The price1
     */
    public String getPrice1() {
        return price1;
    }

    /**
     * 
     * @param price1
     *     The price1
     */
    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    /**
     * 
     * @return
     *     The price2
     */
    public String getPrice2() {
        return price2;
    }

    /**
     * 
     * @param price2
     *     The price2
     */
    public void setPrice2(String price2) {
        this.price2 = price2;
    }

}
