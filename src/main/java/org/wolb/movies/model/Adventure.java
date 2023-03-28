package org.wolb.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "adventures")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adventure {
    @Id
    private ObjectId id;
    private String date;
    private String country;
    private String city;
    private String state;

    public Adventure(String date, String country, String city, String state) {
        this.date = date;
        this.country = country;
        this.city = city;
        this.state = state;
    }
}
