package com.ob.eaisp.commons.exception;

import com.fasterxml.jackson.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.PROPERTY;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NONE;

@JsonIgnoreProperties
@JsonInclude(NON_NULL)
@JsonTypeInfo(include =  PROPERTY, use = NONE)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ErrorData {
    @JsonProperty(value = "Errors", required = true)
    @NotNull
    private List<Error> errors = new ArrayList<>();

    @JsonInclude(NON_NULL)
    @JsonTypeInfo(include =  PROPERTY, use = NONE)
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Error {

        @JsonProperty("ErrorCode")
        @NotNull
        @Schema(example = "EAISP_API_ERR_400_01")
        private String errorCode;

        @JsonProperty("Message")
        @NotNull
        @Schema(example = "Header x-lbg-brand must not be null")
        private String message;

        @JsonProperty("Path")
        @NotNull
        @Schema(example = "Path of the field")
        private String path;

        public Error(String errorCode, String message) {
            this.errorCode = errorCode;
            this.message = message;
        }
    }
    @JsonIgnore
    public String getErrorMessage() {
        if (CollectionUtils.isEmpty(errors)) {
            return errors.get(0).getMessage();
        } else return null;
    }
}
