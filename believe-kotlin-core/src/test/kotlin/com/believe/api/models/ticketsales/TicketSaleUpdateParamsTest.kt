// File generated from our OpenAPI spec by Stainless.

package com.believe.api.models.ticketsales

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TicketSaleUpdateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun pathParams() {
        val params = TicketSaleUpdateParams.builder().ticketSaleId("ticket_sale_id").build()

        assertThat(params._pathParam(0)).isEqualTo("ticket_sale_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.buyerEmail()).isEqualTo("dev@stainless.com")
        assertThat(body.buyerName()).isEqualTo("buyer_name")
        assertThat(body.couponCode()).isEqualTo("coupon_code")
        assertThat(body.currency()).isEqualTo("currency")
        assertThat(body.discount()).isEqualTo("discount")
        assertThat(body.matchId()).isEqualTo("match_id")
        assertThat(body.purchaseMethod()).isEqualTo(PurchaseMethod.ONLINE)
        assertThat(body.quantity()).isEqualTo(1L)
        assertThat(body.subtotal()).isEqualTo("subtotal")
        assertThat(body.tax()).isEqualTo("tax")
        assertThat(body.total()).isEqualTo("total")
        assertThat(body.unitPrice()).isEqualTo("unit_price")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = TicketSaleUpdateParams.builder().ticketSaleId("ticket_sale_id").build()

        val body = params._body()
    }
}
