package com.ob.eaisp.commons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class ResponseData<T> {

    @JsonProperty("Data")
    @Schema (description = "Data returned by the API.")
    private T data;

    @JsonProperty("Links")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(
            description =
                    "Set of elements that provide links to the response pages in case of pagination.")
    private Links links;

    @JsonProperty("Meta")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Schema(description = "Provides information about the data returned in the API response.")
    private Map<String, Object> meta;

    public ResponseData(T data) {
        this.data = data;
    }
    public ResponseData(T data, Links links, Map<String, Object> meta) {
        this.data = data;
        this.links = links;
        this.meta = meta;
    }
}