package com.project.shopping_mall.security.oauth2.attribute;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;


@Getter
@Builder
public class OAuth2Attributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;


    public static OAuth2Attributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes){

            return ofGoogle(userNameAttributeName, attributes);

    }

    private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes){
        String str = (String) attributes.get("name");

        return OAuth2Attributes.builder()
                .name(str)
                .email((String) attributes.get("email"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

}
