/*
 * LIO - Order Management API
 * API de gerenciamento de pedidos da LIO.
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Produto secundário.
 */
@ApiModel(description = "Produto secundário.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-03-09T14:44:13.421Z")
public class SubPaymentProduct {
  @SerializedName("number")
  private Integer number = null;

  @SerializedName("name")
  private String name = null;

  public SubPaymentProduct number(Integer number) {
    this.number = number;
    return this;
  }

   /**
   * Identificação numérica do produto primário da Cielo.
   * @return number
  **/
  @ApiModelProperty(example = "null", required = true, value = "Identificação numérica do produto primário da Cielo.")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public SubPaymentProduct name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Nome do produto primário utilizado.
   * @return name
  **/
  @ApiModelProperty(example = "null", required = true, value = "Nome do produto primário utilizado.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SubPaymentProduct subPaymentProduct = (SubPaymentProduct) o;
    return Objects.equals(this.number, subPaymentProduct.number) &&
        Objects.equals(this.name, subPaymentProduct.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, name);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SubPaymentProduct {\n");
    
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

