package it.magiavventure.story.error;

import it.magiavventure.common.error.MagiavventureException;
import it.magiavventure.common.model.Error;
import lombok.Getter;

@Getter
public class StoryException extends MagiavventureException {

    public static final String STORY_NOT_FOUND = "story-not-found";

    public StoryException(Error error) {
        super(error);
    }

}
