package com.ob.eaisp.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Links {

    @JsonProperty("First")
    @Schema(description = "Link to first page if available.")
    private String first;

    @JsonProperty("Next") @Schema(description = "Link to next page if available.")
    private String next;

    @JsonProperty("Self") @Schema(description = "Link to current page.")
    private String self;

    @JsonProperty("Prev") @Schema(description = "Link to previous page if available.")
    private String prev;

    @JsonProperty("Last")
    @Schema (description = "Link to last page if available.")
    private String last;
}