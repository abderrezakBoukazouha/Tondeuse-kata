package org.winside.kata.spring.batch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.winside.kata.spring.batch.entities.Instructions;
import org.winside.kata.spring.batch.entities.Orientations;
import org.winside.kata.spring.batch.entities.Point;
import org.winside.kata.spring.batch.entities.Tondeuse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.winside.kata.spring.batch.entities.Instructions.*;
import static org.winside.kata.spring.batch.entities.Orientations.*;


public class TondeuseTest {

    @ParameterizedTest
    @MethodSource("generateData")
    public void shouldMoveCorrespondingToInput(int departure_x, int departure_y, Orientations departure_orientation,
                                                List<Instructions> instructions,
                                                int arrival_x, int arrival_y, Orientations arrival_orientation) {
        // Given
        Point departurePoint = new Point(departure_x, departure_y, departure_orientation);
        Tondeuse tondeuse = new Tondeuse(5, 5,departurePoint);

        // when
        tondeuse.execute(instructions);

        // Then
        Assertions.assertEquals(arrival_x, tondeuse.getPoint().getX());
        Assertions.assertEquals(arrival_y, tondeuse.getPoint().getY());
        Assertions.assertEquals(arrival_orientation, tondeuse.getPoint().getOrientation());
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(1,2,N,Arrays.asList(G,A,G,A,G,A,G,A,A),1,3,N),
                Arguments.of(3,3,E,Arrays.asList(A,A,D,A,A,D,A,D,D,A),5,1,E)
        );
    }
}
