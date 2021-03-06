/*
 * Internal Utility API
 * This API allows you to access internal data.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.internal.api.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * IPLevelDTO
 */

public class IPLevelDTO {
  @SerializedName("type")
  private String type = null;

  @SerializedName("fixedIp")
  private String fixedIp = null;

  @SerializedName("startingIp")
  private String startingIp = null;

  @SerializedName("endingIp")
  private String endingIp = null;

  @SerializedName("invert")
  private Boolean invert = null;

  @SerializedName("tenantDomain")
  private String tenantDomain = null;

  @SerializedName("id")
  private Integer id = null;

  public IPLevelDTO type(String type) {
    this.type = type;
    return this;
  }

   /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(example = "iprange", value = "")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public IPLevelDTO fixedIp(String fixedIp) {
    this.fixedIp = fixedIp;
    return this;
  }

   /**
   * IP address.
   * @return fixedIp
  **/
  @ApiModelProperty(value = "IP address.")
  public String getFixedIp() {
    return fixedIp;
  }

  public void setFixedIp(String fixedIp) {
    this.fixedIp = fixedIp;
  }

  public IPLevelDTO startingIp(String startingIp) {
    this.startingIp = startingIp;
    return this;
  }

   /**
   * Ip Range Starting IP
   * @return startingIp
  **/
  @ApiModelProperty(value = "Ip Range Starting IP")
  public String getStartingIp() {
    return startingIp;
  }

  public void setStartingIp(String startingIp) {
    this.startingIp = startingIp;
  }

  public IPLevelDTO endingIp(String endingIp) {
    this.endingIp = endingIp;
    return this;
  }

   /**
   * Ip Range Ending IP.
   * @return endingIp
  **/
  @ApiModelProperty(value = "Ip Range Ending IP.")
  public String getEndingIp() {
    return endingIp;
  }

  public void setEndingIp(String endingIp) {
    this.endingIp = endingIp;
  }

  public IPLevelDTO invert(Boolean invert) {
    this.invert = invert;
    return this;
  }

   /**
   * Condition is invert.
   * @return invert
  **/
  @ApiModelProperty(value = "Condition is invert.")
  public Boolean isInvert() {
    return invert;
  }

  public void setInvert(Boolean invert) {
    this.invert = invert;
  }

  public IPLevelDTO tenantDomain(String tenantDomain) {
    this.tenantDomain = tenantDomain;
    return this;
  }

   /**
   * Get tenantDomain
   * @return tenantDomain
  **/
  @ApiModelProperty(value = "")
  public String getTenantDomain() {
    return tenantDomain;
  }

  public void setTenantDomain(String tenantDomain) {
    this.tenantDomain = tenantDomain;
  }

  public IPLevelDTO id(Integer id) {
    this.id = id;
    return this;
  }

   /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IPLevelDTO ipLevel = (IPLevelDTO) o;
    return Objects.equals(this.type, ipLevel.type) &&
        Objects.equals(this.fixedIp, ipLevel.fixedIp) &&
        Objects.equals(this.startingIp, ipLevel.startingIp) &&
        Objects.equals(this.endingIp, ipLevel.endingIp) &&
        Objects.equals(this.invert, ipLevel.invert) &&
        Objects.equals(this.tenantDomain, ipLevel.tenantDomain) &&
        Objects.equals(this.id, ipLevel.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, fixedIp, startingIp, endingIp, invert, tenantDomain, id);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IPLevelDTO {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    fixedIp: ").append(toIndentedString(fixedIp)).append("\n");
    sb.append("    startingIp: ").append(toIndentedString(startingIp)).append("\n");
    sb.append("    endingIp: ").append(toIndentedString(endingIp)).append("\n");
    sb.append("    invert: ").append(toIndentedString(invert)).append("\n");
    sb.append("    tenantDomain: ").append(toIndentedString(tenantDomain)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

