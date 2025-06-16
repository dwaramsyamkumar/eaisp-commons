package com.ob.eaisp.commons.model;


import com.ob.eaisp.commons.constants.Brand;
import com.ob.eaisp.commons.constants.PatternConstants;
import com.ob.eaisp.commons.validators.IsEnum;
import com.ob.eaisp.commons.validators.NotBlankValidator;
import com.ob.eaisp.commons.validators.PatternValidator;
import com.ob.eaisp.commons.validators.SizeValidator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestContext {

    @NotBlank(message = "{message.header.party.id.blank}", groups = NotBlankValidator.class)
    @Size(
            min = 1,
            max = 24,
            message = "{message.header.party.id.invalid.size}",
            groups = SizeValidator.class)

        @Pattern(
                regexp = PatternConstants.PARTY_ID,
                message = "{message.header.party.id.invalid.pattern}",
                groups = PatternValidator.class)
        private String partyId;

        @IsEnum(
                value = Brand.class,
                message = "{message.header.invalid.brand}",
                groups = NotBlankValidator.class)
        private Brand brand;

        @NotBlank(message = "{message.header.journey.id.blank}", groups = NotBlankValidator.class)
        @Size(
                min = 1,
                max = 40,
                message = "{message.header.journey.id.invalid.size}",
                groups = SizeValidator.class)
        @Pattern(
                regexp = PatternConstants.CLIENT_ID,
                message = "{message.header.journey.id.invalid.pattern}",
                groups = PatternValidator.class)
        private String journeyId;
        private String correlationId;
        private String authorizationHeader;
        private String appVersion;

        public String infoLog() {
            return String.format("PartyId:%s, Brand:%s, JourneyId:%s, AppVersion:%s", partyId, brand, journeyId, appVersion);

        }

    }