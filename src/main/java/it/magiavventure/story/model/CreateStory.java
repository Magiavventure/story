package it.magiavventure.story.model;

import it.magiavventure.mongo.model.Category;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class CreateStory {

    @NotNull
    private String title;
    private String subtitle;
    @NotNull
    private String text;
    @NotNull
    private String author;
    @NotEmpty
    private List<Category> categories;
}
