package org.openapitools.model

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Email
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size
import javax.validation.Valid
import io.swagger.v3.oas.annotations.media.Schema

/**
 * 
 * @param title 
 * @param description 
 * @param hoursDuration 
 * @param orderThreshold 
 * @param rewardAmount 
 */
data class QuestDetails(

    @Schema(example = "null", description = "")
    @get:JsonProperty("title") val title: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("description") val description: kotlin.String? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("hoursDuration") val hoursDuration: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("orderThreshold") val orderThreshold: kotlin.Int? = null,

    @Schema(example = "null", description = "")
    @get:JsonProperty("rewardAmount") val rewardAmount: kotlin.Int? = null
) {

}

