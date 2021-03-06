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
import io.swagger.client.model.Card;
import io.swagger.client.model.PaymentProduct;
import org.joda.time.DateTime;

/**
 * Transaction
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2017-03-09T14:44:13.421Z")
public class Transaction {
  @SerializedName("id")
  private String id = null;

  /**
   * Tipo da transação.
   */
  public enum TransactionTypeEnum {
    @SerializedName("PAYMENT")
    PAYMENT("PAYMENT"),
    
    @SerializedName("CANCELLATION")
    CANCELLATION("CANCELLATION");

    private String value;

    TransactionTypeEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("transaction_type")
  private TransactionTypeEnum transactionType = null;

  /**
   * Status da transação.
   */
  public enum StatusEnum {
    @SerializedName("CONFIRMED")
    CONFIRMED("CONFIRMED"),
    
    @SerializedName("PENDING")
    PENDING("PENDING"),
    
    @SerializedName("CANCELLED")
    CANCELLED("CANCELLED");

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

  @SerializedName("description")
  private String description = null;

  @SerializedName("terminal_number")
  private Integer terminalNumber = null;

  @SerializedName("card")
  private Card card = null;

  @SerializedName("number")
  private Integer number = null;

  @SerializedName("authorization_code")
  private Integer authorizationCode = null;

  @SerializedName("payment_product")
  private PaymentProduct paymentProduct = null;

  @SerializedName("amount")
  private String amount = null;

  @SerializedName("created_at")
  private DateTime createdAt = null;

  @SerializedName("updated_at")
  private DateTime updatedAt = null;

  public Transaction id(String id) {
    this.id = id;
    return this;
  }

   /**
   * UUID que identifica unicamente a transação.
   * @return id
  **/
  @ApiModelProperty(example = "null", required = true, value = "UUID que identifica unicamente a transação.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Transaction transactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
    return this;
  }

   /**
   * Tipo da transação.
   * @return transactionType
  **/
  @ApiModelProperty(example = "null", required = true, value = "Tipo da transação.")
  public TransactionTypeEnum getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionTypeEnum transactionType) {
    this.transactionType = transactionType;
  }

  public Transaction status(StatusEnum status) {
    this.status = status;
    return this;
  }

   /**
   * Status da transação.
   * @return status
  **/
  @ApiModelProperty(example = "null", required = true, value = "Status da transação.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Transaction description(String description) {
    this.description = description;
    return this;
  }

   /**
   * Descrição da transação.
   * @return description
  **/
  @ApiModelProperty(example = "null", value = "Descrição da transação.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Transaction terminalNumber(Integer terminalNumber) {
    this.terminalNumber = terminalNumber;
    return this;
  }

   /**
   * Número do terminal da Cielo Lio em que o pagamento foi realizado.
   * @return terminalNumber
  **/
  @ApiModelProperty(example = "null", required = true, value = "Número do terminal da Cielo Lio em que o pagamento foi realizado.")
  public Integer getTerminalNumber() {
    return terminalNumber;
  }

  public void setTerminalNumber(Integer terminalNumber) {
    this.terminalNumber = terminalNumber;
  }

  public Transaction card(Card card) {
    this.card = card;
    return this;
  }

   /**
   * Get card
   * @return card
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public Card getCard() {
    return card;
  }

  public void setCard(Card card) {
    this.card = card;
  }

  public Transaction number(Integer number) {
    this.number = number;
    return this;
  }

   /**
   * Número Sequencial Único (NSU) da transação.
   * @return number
  **/
  @ApiModelProperty(example = "null", required = true, value = "Número Sequencial Único (NSU) da transação.")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Transaction authorizationCode(Integer authorizationCode) {
    this.authorizationCode = authorizationCode;
    return this;
  }

   /**
   * Código de autorização da transação.
   * @return authorizationCode
  **/
  @ApiModelProperty(example = "null", required = true, value = "Código de autorização da transação.")
  public Integer getAuthorizationCode() {
    return authorizationCode;
  }

  public void setAuthorizationCode(Integer authorizationCode) {
    this.authorizationCode = authorizationCode;
  }

  public Transaction paymentProduct(PaymentProduct paymentProduct) {
    this.paymentProduct = paymentProduct;
    return this;
  }

   /**
   * Get paymentProduct
   * @return paymentProduct
  **/
  @ApiModelProperty(example = "null", required = true, value = "")
  public PaymentProduct getPaymentProduct() {
    return paymentProduct;
  }

  public void setPaymentProduct(PaymentProduct paymentProduct) {
    this.paymentProduct = paymentProduct;
  }

  public Transaction amount(String amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Valor da transação. Exemplo: O valor de R$ 10,00 é representado como 1000.
   * @return amount
  **/
  @ApiModelProperty(example = "null", required = true, value = "Valor da transação. Exemplo: O valor de R$ 10,00 é representado como 1000.")
  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public Transaction createdAt(DateTime createdAt) {
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

  public Transaction updatedAt(DateTime updatedAt) {
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
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.id, transaction.id) &&
        Objects.equals(this.transactionType, transaction.transactionType) &&
        Objects.equals(this.status, transaction.status) &&
        Objects.equals(this.description, transaction.description) &&
        Objects.equals(this.terminalNumber, transaction.terminalNumber) &&
        Objects.equals(this.card, transaction.card) &&
        Objects.equals(this.number, transaction.number) &&
        Objects.equals(this.authorizationCode, transaction.authorizationCode) &&
        Objects.equals(this.paymentProduct, transaction.paymentProduct) &&
        Objects.equals(this.amount, transaction.amount) &&
        Objects.equals(this.createdAt, transaction.createdAt) &&
        Objects.equals(this.updatedAt, transaction.updatedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, transactionType, status, description, terminalNumber, card, number, authorizationCode, paymentProduct, amount, createdAt, updatedAt);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    terminalNumber: ").append(toIndentedString(terminalNumber)).append("\n");
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    authorizationCode: ").append(toIndentedString(authorizationCode)).append("\n");
    sb.append("    paymentProduct: ").append(toIndentedString(paymentProduct)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

