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
import io.swagger.client.model.OrderItem;
import io.swagger.client.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import org.joda.time.DateTime;

/**
 * Order
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-03-09T14:44:13.421Z")
public class Order {
  @SerializedName("id")
  private String id = null;

  @SerializedName("number")
  private String number = null;

  @SerializedName("reference")
  private String reference = null;

  /**
   * Status do pedido.
   */
  public enum StatusEnum {
    @SerializedName("DRAFT")
    DRAFT("DRAFT"),
    
    @SerializedName("ENTERED")
    ENTERED("ENTERED"),
    
    @SerializedName("CANCELED")
    CANCELED("CANCELED"),
    
    @SerializedName("PAID")
    PAID("PAID"),
    
    @SerializedName("APPROVED")
    APPROVED("APPROVED"),
    
    @SerializedName("REJECTED")
    REJECTED("REJECTED"),
    
    @SerializedName("RE-ENTERED")
    RE_ENTERED("RE-ENTERED"),
    
    @SerializedName("CLOSED")
    CLOSED("CLOSED");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("status")
  private StatusEnum status = null;

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("updated_at")
  private DateTime updatedAt = null;

  @SerializedName("items")
  private List<OrderItem> items = new ArrayList<OrderItem>();

  @SerializedName("notes")
  private String notes = null;

  @SerializedName("transactions")
  private List<Transaction> transactions = new ArrayList<Transaction>();

  @SerializedName("price")
  private Integer price = null;

  @SerializedName("remaining")
  private Integer remaining = null;

  public Order id(String id) {
    this.id = id;
    return this;
  }

   /**
   * UUID que identifica unicamente o pedido.
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "UUID que identifica unicamente o pedido.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Order number(String number) {
    this.number = number;
    return this;
  }

   /**
   * Número do pedido. Gerelmente esse número representa o identificador do pedido em um sistema externo através da integração com parceiros.
   * @return number
  **/
  @ApiModelProperty(example = "null", value = "Número do pedido. Gerelmente esse número representa o identificador do pedido em um sistema externo através da integração com parceiros.")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Order reference(String reference) {
    this.reference = reference;
    return this;
  }

   /**
   * Referência do pedido. Utilizada para facilitar o acesso ou localização do mesmo.
   * @return reference
  **/
  @ApiModelProperty(example = "null", value = "Referência do pedido. Utilizada para facilitar o acesso ou localização do mesmo.")
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public Order status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status do pedido.
   * @return status
  **/
  @ApiModelProperty(example = "null", required = true, value = "Status do pedido.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Order createdAt(DateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

   /**
   * Data de criação do pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)
   * @return createdAt
  **/
  @ApiModelProperty(example = "null", required = true, value = "Data de criação do pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)")
  public DateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(DateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Order updatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

   /**
   * Data de última atualização do pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)
   * @return updatedAt
  **/
  @ApiModelProperty(example = "null", required = true, value = "Data de última atualização do pedido. A data deve estar no formato: YYYY-MM-DDThh:mm:ssZ (Exemplo: 20151020T13:13:29.000Z)")
  public DateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(DateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Order items(List<OrderItem> items) {
    this.items = items;
    return this;
  }

  public Order addItemsItem(OrderItem itemsItem) {
    this.items.add(itemsItem);
    return this;
  }

   /**
   * Lista de itens contidos no pedido.
   * @return items
  **/
  @ApiModelProperty(example = "null", required = true, value = "Lista de itens contidos no pedido.")
  public List<OrderItem> getItems() {
    return items;
  }

  public void setItems(List<OrderItem> items) {
    this.items = items;
  }

  public Order notes(String notes) {
    this.notes = notes;
    return this;
  }

   /**
   * Campo disponível para uso do Merchant para comunicação.
   * @return notes
  **/
  @ApiModelProperty(example = "null", value = "Campo disponível para uso do Merchant para comunicação.")
  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Order transactions(List<Transaction> transactions) {
    this.transactions = transactions;
    return this;
  }

  public Order addTransactionsItem(Transaction transactionsItem) {
    this.transactions.add(transactionsItem);
    return this;
  }

   /**
   * Lista de transações de pagamento (ou outros tipos) efetuadas no pedido.
   * @return transactions
  **/
  @ApiModelProperty(example = "null", required = true, value = "Lista de transações de pagamento (ou outros tipos) efetuadas no pedido.")
  public List<Transaction> getTransactions() {
    return transactions;
  }

  public void setTransactions(List<Transaction> transactions) {
    this.transactions = transactions;
  }

  public Order price(Integer price) {
    this.price = price;
    return this;
  }

   /**
   * Valor total do pedido. Exemplo: O valor de R$ 10,00 é representado como 1000.
   * @return price
  **/
  @ApiModelProperty(example = "null", required = true, value = "Valor total do pedido. Exemplo: O valor de R$ 10,00 é representado como 1000.")
  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Order remaining(Integer remaining) {
    this.remaining = remaining;
    return this;
  }

   /**
   * Valor restante do pagamento do pedido.Exemplo: O valor de R$ 10,00 é representado como 1000.
   * @return remaining
  **/
  @ApiModelProperty(example = "null", required = true, value = "Valor restante do pagamento do pedido.Exemplo: O valor de R$ 10,00 é representado como 1000.")
  public Integer getRemaining() {
    return remaining;
  }

  public void setRemaining(Integer remaining) {
    this.remaining = remaining;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.number, order.number) &&
        Objects.equals(this.reference, order.reference) &&
        Objects.equals(this.status, order.status) &&
        Objects.equals(this.createdAt, order.createdAt) &&
        Objects.equals(this.updatedAt, order.updatedAt) &&
        Objects.equals(this.items, order.items) &&
        Objects.equals(this.notes, order.notes) &&
        Objects.equals(this.transactions, order.transactions) &&
        Objects.equals(this.price, order.price) &&
        Objects.equals(this.remaining, order.remaining);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, number, reference, status, createdAt, updatedAt, items, notes, transactions, price, remaining);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
    sb.append("    transactions: ").append(toIndentedString(transactions)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    remaining: ").append(toIndentedString(remaining)).append("\n");
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

