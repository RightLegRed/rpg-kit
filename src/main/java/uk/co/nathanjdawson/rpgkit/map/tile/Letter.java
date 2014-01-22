package uk.co.nathanjdawson.rpgkit.map.tile;

import org.lwjgl.util.Point;

/**
 * Created by Archelaus on 22/01/14.
 */
@SuppressWarnings("unused")
public enum Letter {
    A(      new Point(1,4)),
    B(      new Point(2,4)),
    C(      new Point(3,4)),
    D(      new Point(4,4)),
    E(      new Point(5,4)),
    F(      new Point(6,4)),
    G(      new Point(7,4)),
    H(      new Point(8,4)),
    I(      new Point(9,4)),
    J(      new Point(10,4)),
    K(      new Point(11,4)),
    L(      new Point(12,4)),
    M(      new Point(13,4)),
    N(      new Point(14,4)),
    O(      new Point(15,4)),
    P(      new Point(0,5)),
    Q(      new Point(1,5)),
    R(      new Point(2,5)),
    S(      new Point(3,5)),
    T(      new Point(4,5)),
    U(      new Point(5,5)),
    V(      new Point(6,5)),
    W(      new Point(7,5)),
    X(      new Point(8,5)),
    Y(      new Point(9,5)),
    Z(      new Point(10,5)),
    SPACE(  new Point(0, 0)),
    ONE(    new Point(1, 3)),
    TWO(    new Point(2, 3)),
    THREE(  new Point(3, 3)),
    FOUR(   new Point(4, 3)),
    FIVE(   new Point(5, 3)),
    SIX(    new Point(6, 3)),
    SEVEN(  new Point(7, 3)),
    EIGHT(  new Point(8, 3)),
    NINE(   new Point(9, 3));

    private Letter(final Point point) {
        this.point = point;
    }

    private final Point point;

    public Point getPoint() {
        return point;
    }
}
