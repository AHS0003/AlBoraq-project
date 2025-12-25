package SDIDproject;

public enum BoraqID {
    ID_100(100),
    ID_101(101),
    ID_102(102),
    ID_103(103),
    ID_104(104),
    ID_105(105),
    ID_106(106),
    ID_107(107),
    ID_108(108),
    ID_109(109),
    ID_110(110),
    ID_111(111);

    private final int valueB;

    BoraqID(int valueB) {
        this.valueB = valueB;
    }
    public int getValue() {
        return valueB;
    }
}

