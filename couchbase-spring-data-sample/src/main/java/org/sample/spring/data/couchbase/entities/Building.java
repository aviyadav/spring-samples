package org.sample.spring.data.couchbase.entities;

import com.couchbase.client.java.repository.annotation.Field;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Building {

    @NotNull
    @Id
    private String id;
    
    @NotNull
    @Field
    private String name;
    
    @NotNull
    @Field
    private String companyId;
    
    @Field
    private List<Area> areas = new ArrayList<>();
    
    @Field
    private List<String> phoneNumbers = new ArrayList<>();
}
