package cakar.springframework.sfgapidoc.entities;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "pet")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Pet Entity", description = "Pet Entity")
@Builder
public class Pet implements Serializable {

    @ApiModelProperty(value = "Pet Id Bilgisi")
    @Id
    private String id;


    @ApiModelProperty(value = "Pet Name Bilgisi")
    //@Field(name = "name")
    private String name;

    @ApiModelProperty(value = "Pet Type Bilgisi")
   // @Field(name = "type")
    private String type;
}
