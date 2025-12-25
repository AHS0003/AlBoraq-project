package SDIDproject;

public enum AtlasID {
    ID_600(600),
    ID_602(602),
    ID_60008(60008),
    ID_606(606),
    ID_60006(60006),
    ID_610(610),
    ID_60004(60004),
    ID_614(614),
    ID_616(616),
    ID_618(618),
    ID_620(620),
    ID_622(622),
    ID_624(624),
    ID_626(626),
    ID_106(106),
    ID_110(110),
    ID_112(112),
    ID_114(114),
    ID_116(116),
    ID_15706(15706),
    ID_118(118),
    ID_120(120),
    ID_122(122),
    ID_124(124),
    ID_126(126),
    ID_128(128),
    ID_130(130),
    ID_132(132),
    ID_103(103),
    ID_204(204),
    ID_202(202),
    ID_20000(20000),
    ID_901(901),
    ID_902(902),
    ID_903(903),
    ID_904(904),
    ID_905(905),
    ID_906(906),
    ID_104(104);
    private final int valueA;

    AtlasID(int valueA) {
        this.valueA = valueA;
    }

    public int getValue() {
        return valueA;
    }
}
