// File generated from our OpenAPI spec by Stainless.

package com.believe.api.services.async

import com.believe.api.client.okhttp.BelieveOkHttpClientAsync
import com.believe.api.models.ticketsales.PurchaseMethod
import com.believe.api.models.ticketsales.TicketSaleCreateParams
import com.believe.api.models.ticketsales.TicketSaleUpdateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class TicketSaleServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun create() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val ticketSaleServiceAsync = client.ticketSales()

        val ticketSale =
            ticketSaleServiceAsync.create(
                TicketSaleCreateParams.builder()
                    .buyerName("Mae Green")
                    .currency("GBP")
                    .discount("9.00")
                    .matchId("match-001")
                    .purchaseMethod(PurchaseMethod.ONLINE)
                    .quantity(2L)
                    .subtotal("90.00")
                    .tax("16.20")
                    .total("97.20")
                    .unitPrice("45.00")
                    .buyerEmail("mae.green@example.com")
                    .couponCode("BELIEVE10")
                    .build()
            )

        ticketSale.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun retrieve() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val ticketSaleServiceAsync = client.ticketSales()

        val ticketSale = ticketSaleServiceAsync.retrieve("ticket_sale_id")

        ticketSale.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun update() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val ticketSaleServiceAsync = client.ticketSales()

        val ticketSale =
            ticketSaleServiceAsync.update(
                TicketSaleUpdateParams.builder()
                    .ticketSaleId("ticket_sale_id")
                    .buyerEmail("dev@stainless.com")
                    .buyerName("buyer_name")
                    .couponCode("coupon_code")
                    .currency("currency")
                    .discount("discount")
                    .matchId("match_id")
                    .purchaseMethod(PurchaseMethod.ONLINE)
                    .quantity(1L)
                    .subtotal("subtotal")
                    .tax("tax")
                    .total("total")
                    .unitPrice("unit_price")
                    .build()
            )

        ticketSale.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun list() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val ticketSaleServiceAsync = client.ticketSales()

        val page = ticketSaleServiceAsync.list()

        page.response().validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    suspend fun delete() {
        val client = BelieveOkHttpClientAsync.builder().apiKey("My API Key").build()
        val ticketSaleServiceAsync = client.ticketSales()

        ticketSaleServiceAsync.delete("ticket_sale_id")
    }
}
