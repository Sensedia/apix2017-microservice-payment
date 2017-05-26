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
import org.joda.time.DateTime;

/**
 * OrderItem
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-03-09T14:44:13.421Z")
public class OrderItem {
  @SerializedName("sku")
  private String sku = null;

  @SerializedName("skuType")
  private String skuType = null;

  @SerializedName("name")
  private String name = null;

  @SerializedName("description")
  private String description = null;

  @SerializedName("unit_price")
  private Integer unitPrice = null;

  @SerializedName("quantity")
  private Integer quantity = null;

  /**
   * Unidade de medida.
   */
  public enum UnitOfMeasureEnum {
    @SerializedName("EACH")
    EACH("EACH"),
    
    @SerializedName("HOURS")
    HOURS("HOURS"),
    
    @SerializedName("DAYS")
    DAYS("DAYS"),
    
    @SerializedName("SECONDS")
    SECONDS("SECONDS"),
    
    @SerializedName("CRATE_OF_12")
    CRATE_OF_12("CRATE_OF_12"),
    
    @SerializedName("SIX_PACK")
    SIX_PACK("SIX_PACK"),
    
    @SerializedName("GALLON")
    GALLON("GALLON"),
    
    @SerializedName("LITRE")
    LITRE("LITRE");

    private String value;

    UnitOfMeasureEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("unit_of_measure")
  private UnitOfMeasureEnum unitOfMeasure = null;

  @SerializedName("details")
  private String details = null;

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("updated_at")
  private DateTime updatedAt = null;

  public OrderItem sku(String sku) {
    this.sku = sku;
    return this;
  }

   /**
   * SKU do produto - identificação única do produto, preferencialmente usando identificações do mercado para o produto, como: <br> - Universal Product Code (UPC),<br> - International Article Number (EAN),<br> - Global Trade Item Number (GTIN),<br> - Australian Product Number (APN),<br> - Outros.<br> Caso seu produto não tenha uma identificação global, utilize informe um ID único proprietário para esse produto.
   * @return sku
  **/
  @ApiModelProperty(example = "null", required = true, value = "SKU do produto - identificação única do produto, preferencialmente usando identificações do mercado para o produto, como: <br> - Universal Product Code (UPC),<br> - International Article Number (EAN),<br> - Global Trade Item Number (GTIN),<br> - Australian Product Number (APN),<br> - Outros.<br> Caso seu produto não tenha uma identificação global, utilize informe um ID único proprietário para esse produto.")
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public OrderItem skuType(String skuType) {
    this.skuType = skuType;
    return this;
  }

   /**
   * Tipo de SKU informado, por exemplo:<br> - PTY - para proprietário - ou seja, quando o SKU for sua identificação proprietária.<br> - UPC - Universal Product Code.<br> - EAN - International Article Number.<br> - GTIN - Global Trade Item Number.<br> - APN - Australian Product Number.
   * @return skuType
  **/
  @ApiModelProperty(example = "null", required = true, value = "Tipo de SKU informado, por exemplo:<br> - PTY - para proprietário - ou seja, quando o SKU for sua identificação proprietária.<br> - UPC - Universal Product Code.<br> - EAN - International Article Number.<br> - GTIN - Global Trade Item Number.<br> - APN - Australian Product Number.")
  public String getSkuType() {
    return skuType;
  }

  public void setSkuType(String skuType) {
    this.skuType = skuType;
  }

  public OrderItem name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Nome do produto.
   * @return name
  **/
  @ApiModelProperty(example = "null", value = "Nome do produto.")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrderItem description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Descrição do produto.
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Descrição do produto.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OrderItem unitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
    return this;
  }

   /**
   * Valor unitário do produto. Exemplo: O valor de R$ 10,00 é representado como 1000.
   * @return unitPrice
  **/
  @ApiModelProperty(example = "null", required = true, value = "Valor unitário do produto. Exemplo: O valor de R$ 10,00 é representado como 1000.")
  public Integer getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Integer unitPrice) {
    this.unitPrice = unitPrice;
  }

  public OrderItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

   /**
   * Quantidade de itens. Caso não seja informado será considerado o valor 1.
   * @return quantity
  **/
  @ApiModelProperty(example = "null", value = "Quantidade de itens. Caso não seja informado será considerado o valor 1.")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderItem unitOfMeasure(UnitOfMeasureEnum unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
    return this;
  }

   /**
   * Unidade de medida.
   * @return unitOfMeasure
  **/
  @ApiModelProperty(example = "null", required = true, value = "Unidade de medida.")
  public UnitOfMeasureEnum getUnitOfMeasure() {
    return unitOfMeasure;
  }

  public void setUnitOfMeasure(UnitOfMeasureEnum unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  public OrderItem details(String details) {
    this.details = details;
    return this;
  }

   /**
   * Detalhes do produto.
   * @return details
  **/
  @ApiModelProperty(example = "null", value = "Detalhes do produto.")
  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public OrderItem createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Data da criação/inclusão do item no pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)
   * @return createdAt
  **/
  @ApiModelProperty(example = "null", required = true, value = "Data da criação/inclusão do item no pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public OrderItem updatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Data da última atualização do item no pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)
   * @return updatedAt
  **/
  @ApiModelProperty(example = "null", required = true, value = "Data da última atualização do item no pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)")
  public DateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.sku, orderItem.sku) &&
        Objects.equals(this.skuType, orderItem.skuType) &&
        Objects.equals(this.name, orderItem.name) &&
        Objects.equals(this.description, orderItem.description) &&
        Objects.equals(this.unitPrice, orderItem.unitPrice) &&
        Objects.equals(this.quantity, orderItem.quantity) &&
        Objects.equals(this.unitOfMeasure, orderItem.unitOfMeasure) &&
        Objects.equals(this.details, orderItem.details) &&
        Objects.equals(this.createdAt, orderItem.createdAt) &&
        Objects.equals(this.updatedAt, orderItem.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, skuType, name, description, unitPrice, quantity, unitOfMeasure, details, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    skuType: ").append(toIndentedString(skuType)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    unitPrice: ").append(toIndentedString(unitPrice)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    unitOfMeasure: ").append(toIndentedString(unitOfMeasure)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
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
