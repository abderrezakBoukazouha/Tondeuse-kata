package org.winside.kata.spring.batch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.winside.kata.spring.batch.entities.Orientation;
import org.winside.kata.spring.batch.entities.Point;
import org.winside.kata.spring.batch.useFactories.Mouvement;

import java.util.List;

import static org.winside.kata.spring.batch.entities.Orientation.E;
import static org.winside.kata.spring.batch.entities.Orientation.N;


public class MouvementTest {

    @Test
    public void shouldMooveCorrespondingToInput() {
        // Given
        Point point = new Point(0, 0, N);
        Mouvement mouvement = new Mouvement(point);
        List<Orientation> orientationList = List.of(N,N,E);

        // when
        mouvement.moove(orientationList);

        // Then
        Assertions.assertEquals(1, mouvement.getPoint().getOrdonnee());
    }

}
