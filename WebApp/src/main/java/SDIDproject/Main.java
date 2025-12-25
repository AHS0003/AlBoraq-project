package SDIDproject;

import Dao.ImplReservation;

import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
public class Main {
    public static void main(String[] args) throws CompartimentException, TrainException, ReservationException, HoraireException, GmailException, SQLException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        Train TGV1 = new Boraq();// 12 boraq li kin fnhar
        Train TGV2 = new Boraq();
        Train TGV3 = new Boraq();
        Train TGV4 = new Boraq();
        Train TGV5 = new Boraq();
        Train TGV6 = new Boraq();
        Train TGV7 = new Boraq();
        Train TGV8 = new Boraq();
        Train TGV9 = new Boraq();
        Train TGV10 = new Boraq();
        Train TGV11 = new Boraq();
        Train TGV12 = new Boraq();
        Station st1 = new Station(1, "CASA VOYAGEURS", "CASABLANCA");
        Station st2 = new Station(2, "RABAT AGDAL", "RABAT");
        Station st3 = new Station(3, "KENITRA", "KENITRA");
        Station st4 = new Station(4, "TANGER VILLE", "TANGER");
        // Les TGV dyel Aller
        Horaire hr1_Trajet1 = new Horaire(1,st1, st4, LocalTime.of(6, 0), LocalTime.of(8, 10), TGV1);
        Horaire hr1_Trajet2 = new Horaire(2,st1, st2, LocalTime.of(6, 0), LocalTime.of(6, 45), TGV1);
        Horaire hr1_Trajet3 = new Horaire(3,st1, st3, LocalTime.of(6, 0), LocalTime.of(7, 17), TGV1);
        Horaire hr1_Trajet4 = new Horaire(4,st3, st4, LocalTime.of(7, 17), LocalTime.of(8, 10), TGV1);
        Horaire hr1_Trajet5 = new Horaire(5,st2, st3, LocalTime.of(6, 45), LocalTime.of(7, 17), TGV1);
        Horaire hr1_Trajet6 = new Horaire(6,st2, st4, LocalTime.of(6, 45), LocalTime.of(8, 10), TGV1);
// TGV dyel 7
        Horaire hr2_Trajet1 = new Horaire(7,st1, st4, LocalTime.of(7, 0), LocalTime.of(9, 10), TGV2);
        Horaire hr2_Trajet2 = new Horaire(8,st1, st2, LocalTime.of(7, 0), LocalTime.of(7, 45), TGV2);
        Horaire hr2_Trajet3 = new Horaire(9,st1, st3, LocalTime.of(7, 0), LocalTime.of(8, 17), TGV2);
        Horaire hr2_Trajet4 = new Horaire(10,st3, st4, LocalTime.of(8, 17), LocalTime.of(9, 10), TGV2);
        Horaire hr2_Trajet5 = new Horaire(11,st2, st3, LocalTime.of(7, 45), LocalTime.of(8, 17), TGV2);
        Horaire hr2_Trajet6 = new Horaire(12,st2, st4, LocalTime.of(7, 45), LocalTime.of(9, 10), TGV2);
// TGV dyel 8
        Horaire hr3_Trajet1 = new Horaire(13,st1, st4, LocalTime.of(8, 0), LocalTime.of(10, 10), TGV3);
        Horaire hr3_Trajet2 = new Horaire(14,st1, st2, LocalTime.of(8, 0), LocalTime.of(8, 45), TGV3);
        Horaire hr3_Trajet3 = new Horaire(15,st1, st3, LocalTime.of(8, 0), LocalTime.of(9, 17), TGV3);
        Horaire hr3_Trajet4 = new Horaire(16,st3, st4, LocalTime.of(9, 17), LocalTime.of(10, 10), TGV3);
        Horaire hr3_Trajet5 = new Horaire(17,st2, st3, LocalTime.of(8, 45), LocalTime.of(9, 17), TGV3);
        Horaire hr3_Trajet6 = new Horaire(18,st2, st4, LocalTime.of(8, 45), LocalTime.of(10, 10), TGV3);
// TGV dyel 9
        Horaire hr4_Trajet1 = new Horaire(19,st1, st4, LocalTime.of(9, 0), LocalTime.of(11, 10), TGV4);
        Horaire hr4_Trajet2 = new Horaire(20,st1, st2, LocalTime.of(9, 0), LocalTime.of(9, 45), TGV4);
        Horaire hr4_Trajet3 = new Horaire(21,st1, st3, LocalTime.of(9, 0), LocalTime.of(10, 17), TGV4);
        Horaire hr4_Trajet4 = new Horaire(22,st3, st4, LocalTime.of(10, 17), LocalTime.of(11, 10), TGV4);
        Horaire hr4_Trajet5 = new Horaire(23,st2, st3, LocalTime.of(9, 45), LocalTime.of(10, 17), TGV4);
        Horaire hr4_Trajet6 = new Horaire(24,st2, st4, LocalTime.of(9, 45), LocalTime.of(11, 10), TGV4);
// TGV dyel 10
        Horaire hr5_Trajet1 = new Horaire(25,st1, st4, LocalTime.of(10, 0), LocalTime.of(12, 10), TGV5);
        Horaire hr5_Trajet2 = new Horaire(26,st1, st2, LocalTime.of(10, 0), LocalTime.of(10, 45), TGV5);
        Horaire hr5_Trajet3 = new Horaire(27,st1, st3, LocalTime.of(10, 0), LocalTime.of(11, 17), TGV5);
        Horaire hr5_Trajet4 = new Horaire(28,st3, st4, LocalTime.of(11, 17), LocalTime.of(12, 10), TGV5);
        Horaire hr5_Trajet5 = new Horaire(29,st2, st3, LocalTime.of(10, 45), LocalTime.of(11, 17), TGV5);
        Horaire hr5_Trajet6 = new Horaire(30,st2, st4, LocalTime.of(10, 45), LocalTime.of(12, 10), TGV5);
// TGV dyel 11
        Horaire hr6_Trajet1 = new Horaire(31,st1, st4, LocalTime.of(11, 0), LocalTime.of(13, 10), TGV6);
        Horaire hr6_Trajet2 = new Horaire(32,st1, st2, LocalTime.of(11, 0), LocalTime.of(12, 45), TGV6);
        Horaire hr6_Trajet3 = new Horaire(33,st1, st3, LocalTime.of(11, 0), LocalTime.of(12, 17), TGV6);
        Horaire hr6_Trajet4 = new Horaire(34,st3, st4, LocalTime.of(12, 17), LocalTime.of(13, 10), TGV6);
        Horaire hr6_Trajet5 = new Horaire(35,st2, st3, LocalTime.of(11, 45), LocalTime.of(12, 17), TGV6);
        Horaire hr6_Trajet6 = new Horaire(36,st2, st4, LocalTime.of(11, 45), LocalTime.of(13, 10), TGV6);
        //TGV dyel 12
        Horaire hr7_Trajet1 = new Horaire(37,st1, st4, LocalTime.of(12, 0), LocalTime.of(14, 10), TGV7);
        Horaire hr7_Trajet2 = new Horaire(38,st1, st2, LocalTime.of(12, 0), LocalTime.of(12, 45), TGV7);
        Horaire hr7_Trajet3 = new Horaire(39,st1, st3, LocalTime.of(12, 0), LocalTime.of(13, 17), TGV7);
        Horaire hr7_Trajet4 = new Horaire(40,st3, st4, LocalTime.of(13, 17), LocalTime.of(14, 10), TGV7);
        Horaire hr7_Trajet5 = new Horaire(41,st2, st3, LocalTime.of(12, 45), LocalTime.of(13, 17), TGV7);
        Horaire hr7_Trajet6 = new Horaire(42,st2, st4, LocalTime.of(12, 45), LocalTime.of(14, 10), TGV7);
        //TGV dyel 14
        Horaire hr8_Trajet1 = new Horaire(43,st1, st4, LocalTime.of(14, 0), LocalTime.of(16, 10), TGV8);
        Horaire hr8_Trajet2 = new Horaire(44,st1, st2, LocalTime.of(14, 0), LocalTime.of(14, 45), TGV8);
        Horaire hr8_Trajet3 = new Horaire(45,st1, st3, LocalTime.of(14, 0), LocalTime.of(15, 17), TGV8);
        Horaire hr8_Trajet4 = new Horaire(46,st3, st4, LocalTime.of(15, 17), LocalTime.of(16, 10), TGV8);
        Horaire hr8_Trajet5 = new Horaire(47,st2, st3, LocalTime.of(14, 45), LocalTime.of(15, 17), TGV8);
        Horaire hr8_Trajet6 = new Horaire(48,st2, st4, LocalTime.of(14, 45), LocalTime.of(16, 10), TGV8);
        //TGV dyel 15
        Horaire hr9_Trajet1 = new Horaire(49,st1, st4, LocalTime.of(15, 0), LocalTime.of(17, 10), TGV9);
        Horaire hr9_Trajet2 = new Horaire(50,st1, st2, LocalTime.of(15, 0), LocalTime.of(15, 45), TGV9);
        Horaire hr9_Trajet3 = new Horaire(51,st1, st3, LocalTime.of(15, 0), LocalTime.of(16, 17), TGV9);
        Horaire hr9_Trajet4 = new Horaire(52,st3, st4, LocalTime.of(16, 17), LocalTime.of(17, 10), TGV9);
        Horaire hr9_Trajet5 = new Horaire(53,st2, st3, LocalTime.of(15, 45), LocalTime.of(16, 17), TGV9);
        Horaire hr9_Trajet6 = new Horaire(54,st2, st4, LocalTime.of(15, 45), LocalTime.of(17, 10), TGV9);
        //TGV dyel 16
        Horaire hr10_Trajet1 = new Horaire(55,st1, st4, LocalTime.of(16, 0), LocalTime.of(18, 10), TGV10);
        Horaire hr10_Trajet2 = new Horaire(56,st1, st2, LocalTime.of(16, 0), LocalTime.of(16, 45), TGV10);
        Horaire hr10_Trajet3 = new Horaire(57,st1, st3, LocalTime.of(16, 0), LocalTime.of(17, 17), TGV10);
        Horaire hr10_Trajet4 = new Horaire(58,st3, st4, LocalTime.of(17, 17), LocalTime.of(18, 10), TGV10);
        Horaire hr10_Trajet5 = new Horaire(59,st2, st3, LocalTime.of(16, 45), LocalTime.of(17, 17), TGV10);
        Horaire hr10_Trajet6 = new Horaire(60,st2, st4, LocalTime.of(16, 45), LocalTime.of(18, 10), TGV10);
        //TGV dyel 17
        Horaire hr11_Trajet1 = new Horaire(61,st1, st4, LocalTime.of(17, 0), LocalTime.of(19, 10), TGV11);
        Horaire hr11_Trajet2 = new Horaire(62,st1, st2, LocalTime.of(17, 0), LocalTime.of(17, 45), TGV11);
        Horaire hr11_Trajet3 = new Horaire(63,st1, st3, LocalTime.of(17, 0), LocalTime.of(18, 17), TGV11);
        Horaire hr11_Trajet4 = new Horaire(64,st3, st4, LocalTime.of(18, 17), LocalTime.of(19, 10), TGV11);
        Horaire hr11_Trajet5 = new Horaire(65,st2, st3, LocalTime.of(17, 45), LocalTime.of(18, 17), TGV11);
        Horaire hr11_Trajet6 = new Horaire(66,st2, st4, LocalTime.of(17, 45), LocalTime.of(19, 10), TGV11);
        //TGV dyel 18
        Horaire hr12_Trajet1 = new Horaire(67,st1, st4, LocalTime.of(18, 0), LocalTime.of(20, 10), TGV12);
        Horaire hr12_Trajet2 = new Horaire(68,st1, st2, LocalTime.of(18, 0), LocalTime.of(18, 45), TGV12);
        Horaire hr12_Trajet3 = new Horaire(69,st1, st3, LocalTime.of(18, 0), LocalTime.of(19, 17), TGV12);
        Horaire hr12_Trajet4 = new Horaire(70,st3, st4, LocalTime.of(19, 17), LocalTime.of(20, 10), TGV12);
        Horaire hr12_Trajet5 = new Horaire(71,st2, st3, LocalTime.of(18, 45), LocalTime.of(19, 17), TGV12);
        Horaire hr12_Trajet6 = new Horaire(72,st2, st4, LocalTime.of(18, 45), LocalTime.of(20, 10), TGV12);
        //TGV dyel 19
        Horaire hr13_Trajet1 = new Horaire(73,st1, st4, LocalTime.of(19, 0), LocalTime.of(21, 10), TGV1);
        Horaire hr13_Trajet2 = new Horaire(74,st1, st2, LocalTime.of(19, 0), LocalTime.of(19, 45), TGV1);
        Horaire hr13_Trajet3 = new Horaire(75,st1, st3, LocalTime.of(19, 0), LocalTime.of(20, 17), TGV1);
        Horaire hr13_Trajet4 = new Horaire(76,st3, st4, LocalTime.of(20, 17), LocalTime.of(21, 10), TGV1);
        Horaire hr13_Trajet5 = new Horaire(77,st2, st3, LocalTime.of(19, 45), LocalTime.of(20, 17), TGV1);
        Horaire hr13_Trajet6 = new Horaire(78,st2, st4, LocalTime.of(19, 45), LocalTime.of(21, 10), TGV1);
        //TGV dyel 20
        Horaire hr14_Trajet1 = new Horaire(79,st1, st4, LocalTime.of(20, 0), LocalTime.of(22, 10), TGV2);
        Horaire hr14_Trajet2 = new Horaire(80,st1, st2, LocalTime.of(20, 0), LocalTime.of(20, 45), TGV2);
        Horaire hr14_Trajet3 = new Horaire(81,st1, st3, LocalTime.of(20, 0), LocalTime.of(21, 17), TGV2);
        Horaire hr14_Trajet4 = new Horaire(82,st3, st4, LocalTime.of(21, 17), LocalTime.of(22, 10), TGV2);
        Horaire hr14_Trajet5 = new Horaire(83,st2, st3, LocalTime.of(20, 45), LocalTime.of(21, 17), TGV2);
        Horaire hr14_Trajet6 = new Horaire(84,st2, st4, LocalTime.of(20, 45), LocalTime.of(22, 10), TGV2);
        //TGV dyel 21
        Horaire hr15_Trajet1 = new Horaire(85,st1, st4, LocalTime.of(21, 0), LocalTime.of(23, 10), TGV3);
        Horaire hr15_Trajet2 = new Horaire(86,st1, st2, LocalTime.of(21, 0), LocalTime.of(21, 45), TGV3);
        Horaire hr15_Trajet3 = new Horaire(87,st1, st3, LocalTime.of(21, 0), LocalTime.of(22, 17), TGV3);
        Horaire hr15_Trajet4 = new Horaire(88,st3, st4, LocalTime.of(22, 17), LocalTime.of(23, 10), TGV3);
        Horaire hr15_Trajet5 = new Horaire(89,st2, st3, LocalTime.of(21, 45), LocalTime.of(22, 17), TGV3);
        Horaire hr15_Trajet6 = new Horaire(90,st2, st4, LocalTime.of(21, 45), LocalTime.of(23, 10), TGV3);
        //TGV dyel 22
        Horaire hr16_Trajet1 = new Horaire(91,st1, st4, LocalTime.of(22, 0), LocalTime.of(0, 10), TGV4);
        Horaire hr16_Trajet2 = new Horaire(92,st1, st2, LocalTime.of(22, 0), LocalTime.of(22, 45), TGV4);
        Horaire hr16_Trajet3 = new Horaire(93,st1, st3, LocalTime.of(22, 0), LocalTime.of(23, 17), TGV4);
        Horaire hr16_Trajet4 = new Horaire(94,st3, st4, LocalTime.of(23, 17), LocalTime.of(0, 10), TGV4);
        Horaire hr16_Trajet5 = new Horaire(95,st2, st3, LocalTime.of(22, 45), LocalTime.of(23, 17), TGV4);
        Horaire hr16_Trajet6 = new Horaire(96,st2, st4, LocalTime.of(22, 45), LocalTime.of(0, 10), TGV4);
        // Daba les TGV dyel Retour
        // TGV dyel 6
        Horaire hr17_Trajet1 = new Horaire(97,st4, st1, LocalTime.of(6, 0), LocalTime.of(8, 10), TGV6);
        Horaire hr17_Trajet2 = new Horaire(98,st4, st3, LocalTime.of(6, 0), LocalTime.of(6, 53), TGV6);
        Horaire hr17_Trajet3 = new Horaire(99,st4, st2, LocalTime.of(6, 0), LocalTime.of(7, 25), TGV6);
        Horaire hr17_Trajet4 = new Horaire(100,st3, st2, LocalTime.of(6, 53), LocalTime.of(7, 25), TGV6);
        Horaire hr17_Trajet5 = new Horaire(101,st3, st1, LocalTime.of(6, 53), LocalTime.of(8, 10), TGV6);
        Horaire hr17_Trajet6 = new Horaire(102,st2, st1, LocalTime.of(7, 25), LocalTime.of(8, 10), TGV6);
        // TGV dyel 7
        Horaire hr18_Trajet1 = new Horaire(103,st4, st1, LocalTime.of(7, 0), LocalTime.of(9, 10), TGV7);
        Horaire hr18_Trajet2 = new Horaire(104,st4, st3, LocalTime.of(7, 0), LocalTime.of(7, 53), TGV7);
        Horaire hr18_Trajet3 = new Horaire(105,st4, st2, LocalTime.of(7, 0), LocalTime.of(8, 25), TGV7);
        Horaire hr18_Trajet4 = new Horaire(106,st3, st2, LocalTime.of(7, 53), LocalTime.of(8, 25), TGV7);
        Horaire hr18_Trajet5 = new Horaire(107,st3, st1, LocalTime.of(7, 53), LocalTime.of(9, 10), TGV7);
        Horaire hr18_Trajet6 = new Horaire(108,st2, st1, LocalTime.of(8, 25), LocalTime.of(9, 10), TGV7);
        // TGV dyel 8
        Horaire hr19_Trajet1 = new Horaire(109,st4, st1, LocalTime.of(8, 0), LocalTime.of(10, 10), TGV8);
        Horaire hr19_Trajet2 = new Horaire(110,st4, st3, LocalTime.of(8, 0), LocalTime.of(8, 53), TGV8);
        Horaire hr19_Trajet3 = new Horaire(111,st4, st2, LocalTime.of(8, 0), LocalTime.of(9, 25), TGV8);
        Horaire hr19_Trajet4 = new Horaire(112,st3, st2, LocalTime.of(8, 53), LocalTime.of(9, 25), TGV8);
        Horaire hr19_Trajet5 = new Horaire(113,st3, st1, LocalTime.of(8, 53), LocalTime.of(10, 10), TGV8);
        Horaire hr19_Trajet6 = new Horaire(114,st2, st1, LocalTime.of(9, 25), LocalTime.of(10, 10), TGV8);
        // TGV dyel 9
        Horaire hr20_Trajet1 = new Horaire(115,st4, st1, LocalTime.of(9, 0), LocalTime.of(11, 10), TGV9);
        Horaire hr20_Trajet2 = new Horaire(116,st4, st3, LocalTime.of(9, 0), LocalTime.of(9, 53), TGV9);
        Horaire hr20_Trajet3 = new Horaire(117,st4, st2, LocalTime.of(9, 0), LocalTime.of(10, 25), TGV9);
        Horaire hr20_Trajet4 = new Horaire(118,st3, st2, LocalTime.of(9, 53), LocalTime.of(10, 25), TGV9);
        Horaire hr20_Trajet5 = new Horaire(119,st3, st1, LocalTime.of(9, 53), LocalTime.of(11, 10), TGV9);
        Horaire hr20_Trajet6 = new Horaire(120,st2, st1, LocalTime.of(10, 25), LocalTime.of(11, 10), TGV9);
        // TGV dyel 10
        Horaire hr21_Trajet1 = new Horaire(121,st4, st1, LocalTime.of(10, 0), LocalTime.of(12, 10), TGV10);
        Horaire hr21_Trajet2 = new Horaire(122,st4, st3, LocalTime.of(10, 0), LocalTime.of(10, 53), TGV10);
        Horaire hr21_Trajet3 = new Horaire(123,st4, st2, LocalTime.of(10, 0), LocalTime.of(11, 25), TGV10);
        Horaire hr21_Trajet4 = new Horaire(124,st3, st2, LocalTime.of(10, 53), LocalTime.of(11, 25), TGV10);
        Horaire hr21_Trajet5 = new Horaire(125,st3, st1, LocalTime.of(10, 53), LocalTime.of(12, 10), TGV10);
        Horaire hr21_Trajet6 = new Horaire(126,st2, st1, LocalTime.of(11, 25), LocalTime.of(12, 10), TGV10);
        // TGV dyel 11
        Horaire hr22_Trajet1 = new Horaire(127,st4, st1, LocalTime.of(11, 0), LocalTime.of(13, 10), TGV11);
        Horaire hr22_Trajet2 = new Horaire(128,st4, st3, LocalTime.of(11, 0), LocalTime.of(11, 53), TGV11);
        Horaire hr22_Trajet3 = new Horaire(129,st4, st2, LocalTime.of(11, 0), LocalTime.of(12, 25), TGV11);
        Horaire hr22_Trajet4 = new Horaire(130,st3, st2, LocalTime.of(11, 53), LocalTime.of(12, 25), TGV11);
        Horaire hr22_Trajet5 = new Horaire(131,st3, st1, LocalTime.of(11, 53), LocalTime.of(13, 10), TGV11);
        Horaire hr22_Trajet6 = new Horaire(132,st2, st1, LocalTime.of(12, 25), LocalTime.of(13, 10), TGV11);
        // TGV dyel 12
        Horaire hr23_Trajet1 = new Horaire(133,st4, st1, LocalTime.of(12, 0), LocalTime.of(14, 10), TGV12);
        Horaire hr23_Trajet2 = new Horaire(134,st4, st3, LocalTime.of(12, 0), LocalTime.of(12, 53), TGV12);
        Horaire hr23_Trajet3 = new Horaire(135,st4, st2, LocalTime.of(12, 0), LocalTime.of(13, 25), TGV12);
        Horaire hr23_Trajet4 = new Horaire(136,st3, st2, LocalTime.of(12, 53), LocalTime.of(13, 25), TGV12);
        Horaire hr23_Trajet5 = new Horaire(137,st3, st1, LocalTime.of(12, 53), LocalTime.of(14, 10), TGV12);
        Horaire hr23_Trajet6 = new Horaire(138,st2, st1, LocalTime.of(13, 25), LocalTime.of(14, 10), TGV12);
// TGV dyel 14
        Horaire hr25_Trajet1 = new Horaire(139,st4, st1, LocalTime.of(14, 0), LocalTime.of(16, 10), TGV2);
        Horaire hr25_Trajet2 = new Horaire(140,st4, st3, LocalTime.of(14, 0), LocalTime.of(14, 53), TGV2);
        Horaire hr25_Trajet3 = new Horaire(141,st4, st2, LocalTime.of(14, 0), LocalTime.of(15, 25), TGV2);
        Horaire hr25_Trajet4 = new Horaire(142,st3, st2, LocalTime.of(14, 53), LocalTime.of(15, 25), TGV2);
        Horaire hr25_Trajet5 = new Horaire(143,st3, st1, LocalTime.of(14, 53), LocalTime.of(16, 10), TGV2);
        Horaire hr25_Trajet6 = new Horaire(144,st2, st1, LocalTime.of(15, 25), LocalTime.of(16, 10), TGV2);
        // TGV dyel 15
        Horaire hr26_Trajet1 = new Horaire(145,st4, st1, LocalTime.of(15, 0), LocalTime.of(17, 10), TGV3);
        Horaire hr26_Trajet2 = new Horaire(146,st4, st3, LocalTime.of(15, 0), LocalTime.of(15, 53), TGV3);
        Horaire hr26_Trajet3 = new Horaire(147,st4, st2, LocalTime.of(15, 0), LocalTime.of(16, 25), TGV3);
        Horaire hr26_Trajet4 = new Horaire(148,st3, st2, LocalTime.of(15, 53), LocalTime.of(16, 25), TGV3);
        Horaire hr26_Trajet5 = new Horaire(149,st3, st1, LocalTime.of(15, 53), LocalTime.of(17, 10), TGV3);
        Horaire hr26_Trajet6 = new Horaire(150,st2, st1, LocalTime.of(16, 25), LocalTime.of(17, 10), TGV3);
        // TGV dyel 16
        Horaire hr27_Trajet1 = new Horaire(151,st4, st1, LocalTime.of(16, 0), LocalTime.of(18, 10), TGV4);
        Horaire hr27_Trajet2 = new Horaire(152,st4, st3, LocalTime.of(16, 0), LocalTime.of(16, 53), TGV4);
        Horaire hr27_Trajet3 = new Horaire(153,st4, st2, LocalTime.of(16, 0), LocalTime.of(17, 25), TGV4);
        Horaire hr27_Trajet4 = new Horaire(154,st3, st2, LocalTime.of(16, 53), LocalTime.of(17, 25), TGV4);
        Horaire hr27_Trajet5 = new Horaire(155,st3, st1, LocalTime.of(16, 53), LocalTime.of(18, 10), TGV4);
        Horaire hr27_Trajet6 = new Horaire(156,st2, st1, LocalTime.of(17, 25), LocalTime.of(18, 10), TGV4);
        // TGV dyel 17
        Horaire hr28_Trajet1 = new Horaire(157,st4, st1, LocalTime.of(17, 0), LocalTime.of(19, 10), TGV5);
        Horaire hr28_Trajet2 = new Horaire(158,st4, st3, LocalTime.of(17, 0), LocalTime.of(17, 53), TGV5);
        Horaire hr28_Trajet3 = new Horaire(159,st4, st2, LocalTime.of(17, 0), LocalTime.of(18, 25), TGV5);
        Horaire hr28_Trajet4 = new Horaire(160,st3, st2, LocalTime.of(17, 53), LocalTime.of(18, 25), TGV5);
        Horaire hr28_Trajet5 = new Horaire(161,st3, st1, LocalTime.of(17, 53), LocalTime.of(19, 10), TGV5);
        Horaire hr28_Trajet6 = new Horaire(162,st2, st1, LocalTime.of(18, 25), LocalTime.of(19, 10), TGV5);
        // TGV dyel 18
        Horaire hr29_Trajet1 = new Horaire(163,st4, st1, LocalTime.of(18, 0), LocalTime.of(20, 10), TGV6);
        Horaire hr29_Trajet2 = new Horaire(164,st4, st3, LocalTime.of(18, 0), LocalTime.of(18, 53), TGV6);
        Horaire hr29_Trajet3 = new Horaire(165,st4, st2, LocalTime.of(18, 0), LocalTime.of(19, 25), TGV6);
        Horaire hr29_Trajet4 = new Horaire(166,st3, st2, LocalTime.of(18, 53), LocalTime.of(19, 25), TGV6);
        Horaire hr29_Trajet5 = new Horaire(167,st3, st1, LocalTime.of(18, 53), LocalTime.of(20, 10), TGV6);
        Horaire hr29_Trajet6 = new Horaire(168,st2, st1, LocalTime.of(19, 25), LocalTime.of(20, 10), TGV6);
        // TGV dyel 19
        Horaire hr30_Trajet1 = new Horaire(169,st4, st1, LocalTime.of(19, 0), LocalTime.of(21, 10), TGV7);
        Horaire hr30_Trajet2 = new Horaire(170,st4, st3, LocalTime.of(19, 0), LocalTime.of(19, 53), TGV7);
        Horaire hr30_Trajet3 = new Horaire(171,st4, st2, LocalTime.of(19, 0), LocalTime.of(20, 25), TGV7);
        Horaire hr30_Trajet4 = new Horaire(172,st3, st2, LocalTime.of(19, 53), LocalTime.of(20, 25), TGV7);
        Horaire hr30_Trajet5 = new Horaire(173,st3, st1, LocalTime.of(19, 53), LocalTime.of(21, 10), TGV7);
        Horaire hr30_Trajet6 = new Horaire(174,st2, st1, LocalTime.of(20, 25), LocalTime.of(21, 10), TGV7);
        // TGV dyel 20
        Horaire hr31_Trajet1 = new Horaire(175,st4, st1, LocalTime.of(20, 0), LocalTime.of(22, 10), TGV8);
        Horaire hr31_Trajet2 = new Horaire(176,st4, st3, LocalTime.of(20, 0), LocalTime.of(20, 53), TGV8);
        Horaire hr31_Trajet3 = new Horaire(177,st4, st2, LocalTime.of(20, 0), LocalTime.of(21, 25), TGV8);
        Horaire hr31_Trajet4 = new Horaire(178,st3, st2, LocalTime.of(20, 53), LocalTime.of(21, 25), TGV8);
        Horaire hr31_Trajet5 = new Horaire(179,st3, st1, LocalTime.of(20, 53), LocalTime.of(22, 10), TGV8);
        Horaire hr31_Trajet6 = new Horaire(180,st2, st1, LocalTime.of(21, 25), LocalTime.of(22, 10), TGV8);
        // TGV dyel 21
        Horaire hr32_Trajet1 = new Horaire(181,st4, st1, LocalTime.of(21, 0), LocalTime.of(23, 10), TGV9);
        Horaire hr32_Trajet2 = new Horaire(182,st4, st3, LocalTime.of(21, 0), LocalTime.of(21, 53), TGV9);
        Horaire hr32_Trajet3 = new Horaire(183,st4, st2, LocalTime.of(21, 0), LocalTime.of(22, 25), TGV9);
        Horaire hr32_Trajet4 = new Horaire(184,st3, st2, LocalTime.of(21, 53), LocalTime.of(22, 25), TGV9);
        Horaire hr32_Trajet5 = new Horaire(185,st3, st1, LocalTime.of(21, 53), LocalTime.of(23, 10), TGV9);
        Horaire hr32_Trajet6 = new Horaire(186,st2, st1, LocalTime.of(22, 25), LocalTime.of(23, 10), TGV9);
        // TGV dyel 22
        Horaire hr33_Trajet1 = new Horaire(187,st4, st1, LocalTime.of(22, 0), LocalTime.of(0, 10), TGV10);
        Horaire hr33_Trajet2 = new Horaire(188,st4, st3, LocalTime.of(22, 0), LocalTime.of(22, 53), TGV10);
        Horaire hr33_Trajet3 = new Horaire(189,st4, st2, LocalTime.of(22, 0), LocalTime.of(23, 25), TGV10);
        Horaire hr33_Trajet4 = new Horaire(190,st3, st2, LocalTime.of(22, 53), LocalTime.of(23, 25), TGV10);
        Horaire hr33_Trajet5 = new Horaire(191,st3, st1, LocalTime.of(22, 53), LocalTime.of(0, 10), TGV10);
        Horaire hr33_Trajet6 = new Horaire(192,st2, st1, LocalTime.of(23, 25), LocalTime.of(0, 10), TGV10);
        //Salina Mea Lboraq u l horaire dyelu
        // Les Compartiment daba li ghaden n ajoutiw fl Boraq
        /* Compartiment cp1 = new Compartiment(1, 1);
        Compartiment cp2 = new Compartiment(1, 2);
        Compartiment cp3 = new Compartiment(2, 3);
        Compartiment cp4 = new Compartiment(2, 4);
        Compartiment cp5 = new Compartiment(2, 5);
        Compartiment cp6 = new Compartiment(2, 6);
        Compartiment cp7 = new Compartiment(2, 7); */
        /*for (int j = 1; j <= 7; j++) {
            if (j == 1 || j == 2) {
                Compartiment cp = new Compartiment(1, j);
                for (int i = 1; i <= 60; i++) {
                    cp.addPlace(new Place(i));
                }
                TGV1.addCompartiment(cp);
                TGV2.addCompartiment(cp);
                TGV3.addCompartiment(cp);
                TGV4.addCompartiment(cp);
                TGV5.addCompartiment(cp);
                TGV6.addCompartiment(cp);
                TGV7.addCompartiment(cp);
                TGV8.addCompartiment(cp);
                TGV9.addCompartiment(cp);
                TGV10.addCompartiment(cp);
                TGV11.addCompartiment(cp);
                TGV12.addCompartiment(cp);
            } else {
                Compartiment cp = new Compartiment(2, j);
                for (int i = 1; i <= 60; i++) {
                    Place p1 = new Place(i);
                    cp.addPlace(p1);
                }
                TGV1.addCompartiment(cp);
                TGV2.addCompartiment(cp);
                TGV3.addCompartiment(cp);
                TGV4.addCompartiment(cp);
                TGV5.addCompartiment(cp);
                TGV6.addCompartiment(cp);
                TGV7.addCompartiment(cp);
                TGV8.addCompartiment(cp);
                TGV9.addCompartiment(cp);
                TGV10.addCompartiment(cp);
                TGV11.addCompartiment(cp);
                TGV12.addCompartiment(cp);
            }
        }
        // TGV dyel 1
        Trajet trajet1_TGV1 = new Trajet(1, st1, st2, TGV1);
        Trajet trajet2_TGV1 = new Trajet(2, st1, st3, TGV1);
        trajet2_TGV1.ajouterStation(st2);
        Trajet trajet3_TGV1 = new Trajet(3, st1, st4, TGV1);
        trajet3_TGV1.ajouterStation(st2);
        trajet3_TGV1.ajouterStation(st3);
        Trajet trajet4_TGV1 = new Trajet(4, st2, st3, TGV1);
        Trajet trajet5_TGV1 = new Trajet(5, st2, st4, TGV1);
        trajet5_TGV1.ajouterStation(st3);
        Trajet trajet6_TGV1 = new Trajet(6, st3, st4, TGV1);
// TGV dyel 2
        Trajet trajet7_TGV2 = new Trajet(7, st1, st2, TGV2);
        Trajet trajet8_TGV2 = new Trajet(8, st1, st3, TGV2);
        trajet8_TGV2.ajouterStation(st2);
        Trajet trajet9_TGV2 = new Trajet(9, st1, st4, TGV2);
        trajet9_TGV2.ajouterStation(st2);
        trajet9_TGV2.ajouterStation(st3);
        Trajet trajet10_TGV2 = new Trajet(10, st2, st3, TGV2);
        Trajet trajet11_TGV2 = new Trajet(11, st2, st4, TGV2);
        trajet11_TGV2.ajouterStation(st3);
        Trajet trajet12_TGV2 = new Trajet(12, st3, st4, TGV2);
// TGV dyel 3
        Trajet trajet13_TGV3 = new Trajet(13, st1, st2, TGV3);
        Trajet trajet14_TGV3 = new Trajet(14, st1, st3, TGV3);
        trajet14_TGV3.ajouterStation(st2);
        Trajet trajet15_TGV3 = new Trajet(15, st1, st4, TGV3);
        trajet15_TGV3.ajouterStation(st2);
        trajet15_TGV3.ajouterStation(st3);
        Trajet trajet16_TGV3 = new Trajet(16, st2, st3, TGV3);
        Trajet trajet17_TGV3 = new Trajet(17, st2, st4, TGV3);
        trajet17_TGV3.ajouterStation(st3);
        Trajet trajet18_TGV3 = new Trajet(18, st3, st4, TGV3);
// TGV dyel 4
        Trajet trajet19_TGV4 = new Trajet(19, st1, st2, TGV4);
        Trajet trajet20_TGV4 = new Trajet(20, st1, st3, TGV4);
        trajet20_TGV4.ajouterStation(st2);
        Trajet trajet21_TGV4 = new Trajet(21, st1, st4, TGV4);
        trajet21_TGV4.ajouterStation(st2);
        trajet21_TGV4.ajouterStation(st3);
        Trajet trajet22_TGV4 = new Trajet(22, st2, st3, TGV4);
        Trajet trajet23_TGV4 = new Trajet(23, st2, st4, TGV4);
        trajet23_TGV4.ajouterStation(st3);
        Trajet trajet24_TGV4 = new Trajet(24, st3, st4, TGV4);
// TGV dyel 5
        Trajet trajet25_TGV5 = new Trajet(25, st1, st2, TGV5);
        Trajet trajet26_TGV5 = new Trajet(26, st1, st3, TGV5);
        trajet26_TGV5.ajouterStation(st2);
        Trajet trajet27_TGV5 = new Trajet(27, st1, st4, TGV5);
        trajet27_TGV5.ajouterStation(st2);
        trajet27_TGV5.ajouterStation(st3);
        Trajet trajet28_TGV5 = new Trajet(28, st2, st3, TGV5);
        Trajet trajet29_TGV5 = new Trajet(29, st2, st4, TGV5);
        trajet29_TGV5.ajouterStation(st3);
        Trajet trajet30_TGV5 = new Trajet(30, st3, st4, TGV5);
// TGV dyel 6
        Trajet trajet31_TGV6 = new Trajet(31, st1, st2, TGV6);
        Trajet trajet32_TGV6 = new Trajet(32, st1, st3, TGV6);
        trajet32_TGV6.ajouterStation(st2);
        Trajet trajet33_TGV6 = new Trajet(33, st1, st4, TGV6);
        trajet33_TGV6.ajouterStation(st2);
        trajet33_TGV6.ajouterStation(st3);
        Trajet trajet34_TGV6 = new Trajet(34, st2, st3, TGV6);
        Trajet trajet35_TGV6 = new Trajet(35, st2, st4, TGV6);
        trajet35_TGV6.ajouterStation(st3);
        Trajet trajet36_TGV6 = new Trajet(36, st3, st4, TGV6);
// TGV dyel 7
        Trajet trajet37_TGV7 = new Trajet(37, st1, st2, TGV7);
        Trajet trajet38_TGV7 = new Trajet(38, st1, st3, TGV7);
        trajet38_TGV7.ajouterStation(st2);
        Trajet trajet39_TGV7 = new Trajet(39, st1, st4, TGV7);
        trajet39_TGV7.ajouterStation(st2);
        trajet39_TGV7.ajouterStation(st3);
        Trajet trajet40_TGV7 = new Trajet(40, st2, st3, TGV7);
        Trajet trajet41_TGV7 = new Trajet(41, st2, st4, TGV7);
        trajet41_TGV7.ajouterStation(st3);
        Trajet trajet42_TGV7 = new Trajet(42, st3, st4, TGV7);
// TGV dyel 8
        Trajet trajet43_TGV8 = new Trajet(43, st1, st2, TGV8);
        Trajet trajet44_TGV8 = new Trajet(44, st1, st3, TGV8);
        trajet44_TGV8.ajouterStation(st2);
        Trajet trajet45_TGV8 = new Trajet(45, st1, st4, TGV8);
        trajet45_TGV8.ajouterStation(st2);
        trajet45_TGV8.ajouterStation(st3);
        Trajet trajet46_TGV8 = new Trajet(46, st2, st3, TGV8);
        Trajet trajet47_TGV8 = new Trajet(47, st2, st4, TGV8);
        trajet47_TGV8.ajouterStation(st3);
        Trajet trajet48_TGV8 = new Trajet(48, st3, st4, TGV8);
// TGV  9
        Trajet trajet49_TGV9 = new Trajet(49, st1, st2, TGV9);
        Trajet trajet50_TGV9 = new Trajet(50, st1, st3, TGV9);
        trajet50_TGV9.ajouterStation(st2);
        Trajet trajet51_TGV9 = new Trajet(51, st1, st4, TGV9);
        trajet51_TGV9.ajouterStation(st2);
        trajet51_TGV9.ajouterStation(st3);
        Trajet trajet52_TGV9 = new Trajet(52, st2, st3, TGV9);
        Trajet trajet53_TGV9 = new Trajet(53, st2, st4, TGV9);
        trajet53_TGV9.ajouterStation(st3);
        Trajet trajet54_TGV9 = new Trajet(54, st3, st4, TGV9);
        // TGV 10
        Trajet trajet55_TGV10 = new Trajet(55, st1, st2, TGV10);
        Trajet trajet56_TGV10 = new Trajet(56, st1, st3, TGV10);
        trajet56_TGV10.ajouterStation(st2);
        Trajet trajet57_TGV10 = new Trajet(57, st1, st4, TGV10);
        trajet57_TGV10.ajouterStation(st2);
        trajet57_TGV10.ajouterStation(st3);
        Trajet trajet58_TGV10 = new Trajet(58, st2, st3, TGV10);
        Trajet trajet59_TGV10 = new Trajet(59, st2, st4, TGV10);
        trajet59_TGV10.ajouterStation(st3);
        Trajet trajet60_TGV10 = new Trajet(60, st3, st4, TGV10);
        // TGV 11
        Trajet trajet61_TGV11 = new Trajet(61, st1, st2, TGV11);
        Trajet trajet62_TGV11 = new Trajet(62, st1, st3, TGV11);
        trajet62_TGV11.ajouterStation(st2);
        Trajet trajet63_TGV11 = new Trajet(63, st1, st4, TGV11);
        trajet63_TGV11.ajouterStation(st2);
        trajet63_TGV11.ajouterStation(st3);
        Trajet trajet64_TGV11 = new Trajet(64, st2, st3, TGV11);
        Trajet trajet65_TGV11 = new Trajet(65, st2, st4, TGV11);
        trajet65_TGV11.ajouterStation(st3);
        Trajet traje66_TGV11 = new Trajet(66, st3, st4, TGV11);
        // TGV 12
        Trajet trajet67_TGV12 = new Trajet(67, st1, st2, TGV12);
        Trajet trajet68_TGV12 = new Trajet(68, st1, st3, TGV12);
        trajet68_TGV12.ajouterStation(st2);
        Trajet trajet69_TGV12 = new Trajet(69, st1, st4, TGV12);
        trajet69_TGV12.ajouterStation(st2);
        trajet69_TGV12.ajouterStation(st3);
        Trajet trajet70_TGV12 = new Trajet(70, st2, st3, TGV12);
        Trajet trajet71_TGV12 = new Trajet(71, st2, st4, TGV12);
        trajet71_TGV12.ajouterStation(st3);
        Trajet trajet72_TGV12 = new Trajet(72, st3, st4, TGV12);
        //
        ImplReservation reservation = new ImplReservation();
        System.out.println("Enter votre Nom Complet :");
        String nom = sc.nextLine();
        System.out.println("Enter votre email :");
        String email = sc.nextLine();
        String adress1 = "@gmail.com";
        String adress2 = "@hotmail.com";
        String adress3 = "@yahoo.fr";
        String adress4 = "@yopmail.com";
        Pattern pattern1 = Pattern.compile(adress1, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(email);
        boolean matchFound1 = matcher1.find();
        Pattern pattern2 = Pattern.compile(adress2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(email);
        boolean matchFound2 = matcher2.find();
        Pattern pattern3 = Pattern.compile(adress3, Pattern.CASE_INSENSITIVE);
        Matcher matcher3 = pattern3.matcher(email);
        boolean matchFound3 = matcher3.find();
        Pattern pattern4 = Pattern.compile(adress4, Pattern.CASE_INSENSITIVE);
        Matcher matcher4 = pattern4.matcher(email);
        boolean matchFound4 = matcher4.find();
        if (!(matchFound1 || matchFound4 || matchFound3 || matchFound2)) {
            throw new GmailException("Erreur , ce type d'email n'existe pas");
        }
        System.out.println("Enter votre numero :");
        String numero = sc.nextLine();
        System.out.println("Enter votre age :");
        int age = sc.nextInt();
        Voyageur vg = new Voyageur(nom, email, numero, age);
        reservation.ajouterVoyageur(vg);
        sc.nextLine();
        System.out.println("Entrer votre gare de depart : ");
        String depart = sc.nextLine();
        depart = depart.toUpperCase();
        System.out.println("Entrer votre gare d'arrive : ");
        String arrive = sc.nextLine();
        arrive = arrive.toUpperCase();
        System.out.println("Entrer votre date de voyage  yyyy-MM-dd :");
        String input = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(input, formatter);
        /////////////////////////////
        double prix = 0;
        if ((depart.equals("CASA VOYAGEURS") && arrive.equals("RABAT AGDAL") && age<3) && (arrive.equals("CASA VOYAGEURS") && depart.equals("RABAT AGDAL") && age < 3)){
            prix = 0;
        }
        else if ((depart.equals("CASA VOYAGEURS") && arrive.equals("RABAT AGDAL") && age <15) || (arrive.equals("CASA VOYAGEURS") && depart.equals("RABAT AGDAL") && age <15)){
            prix = 42;
        }else if ((depart.equals("CASA VOYAGEURS") && arrive.equals("RABAT AGDAL") && age >=15) || (arrive.equals("CASA VOYAGEURS") && depart.equals("RABAT AGDAL") && age >=15)){
            prix = 60;
        }
        if ((depart.equals("CASA VOYAGEURS") && arrive.equals("KENITRA") && age <3) || (arrive.equals("CASA VOYAGEURS") && depart.equals("KENITRA") && age <3)){
            prix = 0;
        }else if ((depart.equals("CASA VOYAGEURS") && arrive.equals("KENITRA") && age <15) ||(arrive.equals("CASA VOYAGEURS") && depart.equals("KENITRA") && age <15)){
            prix = 50;
        }else if ((depart.equals("CASA VOYAGEURS") && arrive.equals("KENITRA") && age >=15) ||(arrive.equals("CASA VOYAGEURS") && depart.equals("KENITRA") && age >=15)){
            prix = 80;
        }
        if ((depart.equals("CASA VOYAGEURS") && arrive.equals("TANGER VILLE") && age<3)||(arrive.equals("CASA VOYAGEURS") && depart.equals("TANGER VILLE") && age<3)){
            prix = 0;
        }else if ((depart.equals("CASA VOYAGEURS") && arrive.equals("TANGER VILLE") && age <15)||(arrive.equals("CASA VOYAGEURS") && depart.equals("TANGER VILLE") && age<15)){
            prix = 50;
        }else if ((depart.equals("CASA VOYAGEURS") && arrive.equals("TANGER VILLE") && age >=15)||(arrive.equals("CASA VOYAGEURS") && depart.equals("TANGER VILLE") && age>=15)){
            prix = 295;
        }
        if ((depart.equals("RABAT AGDAL") && arrive.equals("KENITRA") && age<3)||(arrive.equals("RABAT AGDAL") && depart.equals("KENITRA") && age<3)){
            prix = 0;
        }else if ((depart.equals("RABAT AGDAL") && arrive.equals("KENITRA") && age<15)||(arrive.equals("RABAT AGDAL") && depart.equals("KENITRA") && age<15)){
            prix = 16;
        }else if ((depart.equals("RABAT AGDAL") && arrive.equals("KENITRA") && age>=15)||(arrive.equals("RABAT AGDAL") && depart.equals("KENITRA") && age>=15)){
            prix = 35;
        }
        if ((depart.equals("RABAT AGDAL") && arrive.equals("TANGER VILLE") && age<3)||(arrive.equals("RABAT AGDAL") && depart.equals("TANGER VILLE") && age<3)){
            prix = 0;
        }else if ((depart.equals("RABAT AGDAL") && arrive.equals("TANGER VILLE") && age <15) || (arrive.equals("RABAT AGDAL") && depart.equals("TANGER VILLE") && age <15)){
            prix = 50;
        }else if ((depart.equals("RABAT AGDAL") && arrive.equals("TANGER VILLE") && age >=15) || (arrive.equals("RABAT AGDAL") && depart.equals("TANGER VILLE") && age >=15)){
            prix = 205;
        }
        if ((depart.equals("KENITRA") && arrive.equals("TANGER VILLE") && age<3) ||(arrive.equals("KENITRA") && depart.equals("TANGER VILLE") && age<3)){
            prix = 0;
        }else if ((depart.equals("KENITRA") && arrive.equals("TANGER VILLE") && age <15)||(arrive.equals("KENITRA") && depart.equals("TANGER VILLE") && age <15)){
            prix = 50;
        }else if ((depart.equals("KENITRA") && arrive.equals("TANGER VILLE") && age >=15)||(arrive.equals("KENITRA") && depart.equals("TANGER VILLE") && age >=15)){
            prix = 170;
        }
        /////////////////////////////////////////////////
        Horaire[] hr_Rabat_Casa = {hr17_Trajet6, hr18_Trajet6, hr19_Trajet6, hr20_Trajet6, hr21_Trajet6, hr22_Trajet6,
                hr23_Trajet6, hr25_Trajet6, hr26_Trajet6, hr27_Trajet6, hr28_Trajet6, hr29_Trajet6, hr30_Trajet6,
                hr31_Trajet6, hr32_Trajet6, hr33_Trajet6
        };
        Horaire[] hr_Casa_Rabat = {hr1_Trajet2, hr2_Trajet2, hr3_Trajet2, hr4_Trajet2, hr5_Trajet2, hr6_Trajet2,
                hr7_Trajet2, hr8_Trajet2, hr9_Trajet2, hr10_Trajet2, hr11_Trajet2, hr12_Trajet2, hr13_Trajet2, hr14_Trajet2,
                hr15_Trajet2, hr16_Trajet2
        };
        Horaire[] hr_Casa_Kenitra = {hr1_Trajet3, hr2_Trajet3, hr3_Trajet3, hr4_Trajet3, hr5_Trajet3, hr6_Trajet3,
                hr7_Trajet3, hr8_Trajet3, hr9_Trajet3, hr10_Trajet3, hr11_Trajet3, hr12_Trajet3, hr13_Trajet3, hr14_Trajet3,
                hr15_Trajet3, hr16_Trajet3
        };
        Horaire[] hr_Casa_Tanger = {hr1_Trajet1, hr2_Trajet1, hr3_Trajet1, hr4_Trajet1, hr5_Trajet1, hr6_Trajet1,
                hr7_Trajet1, hr8_Trajet1, hr9_Trajet1, hr10_Trajet1, hr11_Trajet1, hr12_Trajet1, hr13_Trajet1, hr14_Trajet1,
                hr15_Trajet1, hr16_Trajet1
        };
        Horaire[] hr_Rabat_Kenitra = {hr1_Trajet5, hr2_Trajet5, hr3_Trajet5, hr4_Trajet5, hr5_Trajet5, hr6_Trajet5,
                hr7_Trajet5, hr8_Trajet5, hr9_Trajet5, hr10_Trajet5, hr11_Trajet5, hr12_Trajet5, hr13_Trajet5, hr14_Trajet5,
                hr15_Trajet5, hr16_Trajet5
        };
        Horaire[] hr_Rabat_Tanger = {hr1_Trajet6, hr2_Trajet6, hr3_Trajet6, hr4_Trajet6, hr5_Trajet6, hr6_Trajet6,
                hr7_Trajet6, hr8_Trajet6, hr9_Trajet6, hr10_Trajet6, hr11_Trajet6, hr12_Trajet6, hr13_Trajet6, hr14_Trajet6,
                hr15_Trajet6, hr16_Trajet6
        };
        Horaire[] hr_Kenitra_Tanger = {hr1_Trajet4, hr2_Trajet4, hr3_Trajet4, hr4_Trajet4, hr5_Trajet4, hr6_Trajet4,
                hr7_Trajet4, hr8_Trajet4, hr9_Trajet4, hr10_Trajet4, hr11_Trajet4, hr12_Trajet4, hr13_Trajet4, hr14_Trajet4,
                hr15_Trajet4, hr16_Trajet4
        };
        Horaire[] hr_Tanger_Rabat = {hr17_Trajet3, hr18_Trajet3, hr19_Trajet3, hr20_Trajet3, hr21_Trajet3, hr22_Trajet3,
                hr23_Trajet3, hr25_Trajet3, hr26_Trajet3, hr27_Trajet3, hr28_Trajet3, hr29_Trajet3, hr30_Trajet3,
                hr31_Trajet3, hr32_Trajet3, hr33_Trajet3
        };
        Horaire[] hr_Tanger_Kenitra = {hr17_Trajet2, hr18_Trajet2, hr19_Trajet2, hr20_Trajet2, hr21_Trajet2, hr22_Trajet2,
                hr23_Trajet2, hr25_Trajet2, hr26_Trajet2, hr27_Trajet2, hr28_Trajet2, hr29_Trajet2, hr30_Trajet2,
                hr31_Trajet2, hr32_Trajet2, hr33_Trajet2
        };
        Horaire[] hr_Kenitra_Rabat = {hr17_Trajet4, hr18_Trajet4, hr19_Trajet4, hr20_Trajet4, hr21_Trajet4, hr22_Trajet4,
                hr23_Trajet4, hr25_Trajet4, hr26_Trajet4, hr27_Trajet4, hr28_Trajet4, hr29_Trajet4, hr30_Trajet4,
                hr31_Trajet4, hr32_Trajet4, hr33_Trajet4
        };
        Horaire[] hr_Kenitra_Casa = {hr17_Trajet5, hr18_Trajet5, hr19_Trajet5, hr20_Trajet5, hr21_Trajet5, hr22_Trajet5,
                hr23_Trajet5, hr25_Trajet5, hr26_Trajet5, hr27_Trajet5, hr28_Trajet5, hr29_Trajet5, hr30_Trajet5,
                hr31_Trajet5, hr32_Trajet5, hr33_Trajet5
        };
        Horaire[] hr_Tanger_Voyageur = {hr17_Trajet1, hr18_Trajet1, hr19_Trajet1, hr20_Trajet1, hr21_Trajet1, hr22_Trajet1,
                hr23_Trajet1, hr25_Trajet1, hr26_Trajet1, hr27_Trajet1, hr28_Trajet1, hr29_Trajet1, hr30_Trajet1,
                hr31_Trajet1, hr32_Trajet1, hr33_Trajet1
        };
        //////////////////////////////////////////////////////
        LocalTime time = LocalTime.now();
        Time sqlTime = Time.valueOf(time);
        LocalDate date_now = LocalDate.now();
        if (date_now.equals(date)) {
            if (depart.equals("CASA VOYAGEURS") && arrive.equals("RABAT AGDAL")) {
                    for (int i = 0; i < hr_Casa_Rabat.length; i++) {
                        if (hr_Casa_Rabat[i].getHeureDepart().after(sqlTime)) {
                            System.out.println(hr_Casa_Rabat[i].toString());
                            System.out.println("\n");
                        } else if (hr_Casa_Rabat[15].getHeureDepart().before(sqlTime)) {
                            throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }

            if (depart.equals("CASA VOYAGEURS") && arrive.equals("KENITRA")) {
                for (int i = 0; i < hr_Casa_Kenitra.length; i++) {
                    if (hr_Casa_Kenitra[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Casa_Kenitra[i].toString());
                        System.out.println("\n");
                    } else if (hr_Casa_Kenitra[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("CASA VOYAGEURS") && arrive.equals("TANGER VILLE")) {
                for (int i = 0; i < hr_Casa_Tanger.length; i++) {
                    if (hr_Casa_Tanger[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Casa_Tanger[i].toString());
                        System.out.println("\n");
                    } else if (hr_Casa_Tanger[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("RABAT AGDAL") && arrive.equals("KENITRA")) {
                for (int i = 0; i < hr_Rabat_Kenitra.length; i++) {
                    if (hr_Rabat_Kenitra[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Rabat_Kenitra[i].toString());
                        System.out.println("\n");
                    } else if (hr_Rabat_Kenitra[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("RABAT AGDAL") && arrive.equals("TANGER VILLE")) {
                for (int i = 0; i < hr_Rabat_Tanger.length; i++) {
                    if (hr_Rabat_Tanger[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Rabat_Tanger[i].toString());
                        System.out.println("\n");
                    } else if (hr_Rabat_Tanger[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("KENITRA") && arrive.equals("TANGER VILLE")) {
                for (int i = 0; i < hr_Kenitra_Tanger.length; i++) {
                    if (hr_Kenitra_Tanger[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Kenitra_Tanger[i].toString());
                        System.out.println("\n");
                    } else if (hr_Kenitra_Tanger[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("TANGER VILLE") && arrive.equals("CASA VOYAGEURS")) {
                for (int i = 0; i < hr_Tanger_Voyageur.length; i++) {
                    if (hr_Tanger_Voyageur[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Tanger_Voyageur[i].toString());
                        System.out.println("\n");
                    } else if (hr_Tanger_Voyageur[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("TANGER VILLE") && arrive.equals("RABAT AGDAL")) {
                for (int i = 0; i < hr_Tanger_Rabat.length; i++) {
                    if (hr_Tanger_Rabat[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Tanger_Rabat[i].toString());
                        System.out.println("\n");
                    } else if (hr_Tanger_Rabat[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("TANGER VILLE") && arrive.equals("KENITRA")) {
                for (int i = 0; i < hr_Tanger_Kenitra.length; i++) {
                    if (hr_Tanger_Kenitra[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Tanger_Kenitra[i].toString());
                        System.out.println("\n");
                    } else if (hr_Tanger_Kenitra[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("KENITRA") && arrive.equals("RABAT AGDAL")) {
                for (int i = 0; i < hr_Kenitra_Rabat.length; i++) {
                    if (hr_Kenitra_Rabat[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Kenitra_Rabat[i].toString());
                        System.out.println("\n");
                    } else if (hr_Kenitra_Rabat[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("KENITRA") && arrive.equals("CASA VOYAGEURS")) {
                for (int i = 0; i < hr_Kenitra_Casa.length; i++) {
                    if (hr_Kenitra_Casa[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Kenitra_Casa[i].toString());
                        System.out.println("\n");
                    } else if (hr_Kenitra_Casa[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
            if (depart.equals("RABAT AGDAL") && arrive.equals("CASA VOYAGEURS")) {
                for (int i = 0; i < hr_Rabat_Casa.length; i++) {
                    if (hr_Rabat_Casa[i].getHeureDepart().after(sqlTime)) {
                        System.out.println(hr_Rabat_Casa[i].toString());
                        System.out.println("\n");
                    } else if (hr_Rabat_Casa[15].getHeureDepart().before(sqlTime)) {
                        throw new HoraireException("Il n'ya aucun train ");
                    }
                }
            }
        }
        else if (date_now.isBefore(date)) {
            if (depart.equals("CASA VOYAGEURS") && arrive.equals("RABAT AGDAL")) {
                for (int i = 0; i < hr_Casa_Rabat.length; i++) {
                    System.out.println(hr_Casa_Rabat[i].toString());
                    System.out.println("\n");

                }
            }
            if (depart.equals("CASA VOYAGEURS") && arrive.equals("KENITRA")) {
                for (int i = 0; i < hr_Casa_Kenitra.length; i++) {
                    System.out.println(hr_Casa_Kenitra[i].toString());
                    System.out.println("\n");
                }
            }
            if (depart.equals("CASA VOYAGEURS") && arrive.equals("TANGER VILLE")) {
                for (int i = 0; i < hr_Casa_Tanger.length; i++) {
                    System.out.println(hr_Casa_Tanger[i].toString());
                    System.out.println("\n");
                }
            }
            if (depart.equals("RABAT AGDAL") && arrive.equals("KENITRA")) {
                for (int i = 0; i < hr_Rabat_Kenitra.length; i++) {
                    System.out.println(hr_Rabat_Kenitra[i].toString());
                    System.out.println("\n");
                }
            }
            if (depart.equals("RABAT AGDAL") && arrive.equals("TANGER VILLE")) {
                for (int i = 0; i < hr_Rabat_Tanger.length; i++) {
                    System.out.println(hr_Rabat_Tanger[i].toString());
                    System.out.println("\n");
                }
            }
            if (depart.equals("KENITRA") && arrive.equals("TANGER VILLE")) {
                for (int i = 0; i < hr_Kenitra_Tanger.length; i++) {
                        System.out.println(hr_Kenitra_Tanger[i].toString());
                        System.out.println("\n");
                    }
                }
            if (depart.equals("TANGER VILLE") && arrive.equals("CASA VOYAGEURS")) {
                for (int i = 0; i < hr_Tanger_Voyageur.length; i++) {
                        System.out.println(hr_Tanger_Voyageur[i].toString());
                        System.out.println("\n");
                    }
                }
            if (depart.equals("TANGER VILLE") && arrive.equals("RABAT AGDAL")) {
                for (int i = 0; i < hr_Tanger_Rabat.length; i++) {
                        System.out.println(hr_Tanger_Rabat[i].toString());
                        System.out.println("\n");
                    }
                }
            if (depart.equals("TANGER VILLE") && arrive.equals("KENITRA")) {
                for (int i = 0; i < hr_Tanger_Kenitra.length; i++) {
                    System.out.println(hr_Tanger_Kenitra[i].toString());
                    System.out.println("\n");
                }
            }
            if (depart.equals("KENITRA") && arrive.equals("RABAT AGDAL")) {
                for (int i = 0; i < hr_Kenitra_Rabat.length; i++) {
                        System.out.println(hr_Kenitra_Rabat[i].toString());
                        System.out.println("\n");
                    }
                }
            if (depart.equals("KENITRA") && arrive.equals("CASA VOYAGEURS")) {
                for (int i = 0; i < hr_Kenitra_Casa.length; i++) {
                        System.out.println(hr_Kenitra_Casa[i].toString());
                        System.out.println("\n");
                    }
                }
            if (depart.equals("RABAT AGDAL") && arrive.equals("CASA VOYAGEURS")) {
                for (int i = 0; i < hr_Rabat_Casa.length; i++) {
                        System.out.println(hr_Rabat_Casa[i].toString());
                        System.out.println("\n");
                    }
                }
        }
        Horaire[][] horaires = {
                hr_Casa_Rabat, hr_Casa_Kenitra, hr_Casa_Tanger, hr_Rabat_Kenitra, hr_Rabat_Tanger,
                hr_Kenitra_Tanger, hr_Tanger_Voyageur, hr_Tanger_Rabat, hr_Tanger_Kenitra, hr_Kenitra_Rabat,
                hr_Kenitra_Casa, hr_Rabat_Casa
        };
        System.out.println("Quelle horaire vous avez choisi , entrer l'id du l'horaire : ");
        int choixhoraire = sc.nextInt();
        /////////////////////////////////
        Horaire hrs = hr1_Trajet1;
        for (int i = 0; i < horaires.length; i++) {
            for (int j = 0; j < horaires[i].length; j++) {
                if (horaires[i][j].getId() == choixhoraire) {
                    hrs = horaires[i][j];
                }
            }
        }
            /// ////////////////////////////
            System.out.println("Vous voulez reserver une place 1 ere class ou 2 eme class \n(1.Pour 1 ere class) \n(2.Pour 2 eme class)");
            int choixclasscompartiment = sc.nextInt();
            int choixcompartiment;
            if (choixclasscompartiment == 1) {
                System.out.println("Entrer quel compartiment 1 ou 2 ");
                choixcompartiment = sc.nextInt();
            } else {
                System.out.println("Entrer quel compartiment du 3 jusqu'a 7 ");
                choixcompartiment = sc.nextInt();
            }
            System.out.println("Choisi votre place (entre 1 et 60) :");
            int choixplace = sc.nextInt();
            System.out.println("Comment Vous voulez payer : ");
            String paymentMethode = sc.next();
            ModePaiement md = new ModePaiement(paymentMethode);
            Compartiment compa = hrs.getTrain().trouverCompartiment(choixcompartiment);
            Reservation rs = new Reservation(vg, hrs.getTrain(), hrs, compa, compa.trouverPlace(choixplace), prix, md,date);
            reservation.ajouterreservation(rs);
            rs.reserverPlace();
            Billet ticket = new Billet(rs);
            System.out.println(ticket.printBilletsPDF());*/
           ImplReservation metier = new ImplReservation();
        }
}