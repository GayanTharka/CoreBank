//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.09.15 at 03:28:12 AM IST 
//


package com.tharaka.corebank.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromAccountNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="toAccountNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fromAccountNo",
    "toAccountNo",
    "bankCode",
    "amount"
})
@XmlRootElement(name = "fundTransferToOtherAccountRequest")
public class FundTransferToOtherAccountRequest {

    protected int fromAccountNo;
    protected int toAccountNo;
    protected int bankCode;
    protected double amount;

    /**
     * Gets the value of the fromAccountNo property.
     * 
     */
    public int getFromAccountNo() {
        return fromAccountNo;
    }

    /**
     * Sets the value of the fromAccountNo property.
     * 
     */
    public void setFromAccountNo(int value) {
        this.fromAccountNo = value;
    }

    /**
     * Gets the value of the toAccountNo property.
     * 
     */
    public int getToAccountNo() {
        return toAccountNo;
    }

    /**
     * Sets the value of the toAccountNo property.
     * 
     */
    public void setToAccountNo(int value) {
        this.toAccountNo = value;
    }

    /**
     * Gets the value of the bankCode property.
     * 
     */
    public int getBankCode() {
        return bankCode;
    }

    /**
     * Sets the value of the bankCode property.
     * 
     */
    public void setBankCode(int value) {
        this.bankCode = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     */
    public void setAmount(double value) {
        this.amount = value;
    }

}
