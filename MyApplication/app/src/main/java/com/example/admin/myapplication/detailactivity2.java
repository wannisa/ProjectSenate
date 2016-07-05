package com.example.admin.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.ListView;

import android.widget.Toast;

import com.example.admin.myapplication.adapter.ShowEng;
import com.example.admin.myapplication.adapter.ShowVocabularyAdapter;
import com.example.admin.myapplication.database.DatabaseHalper;
import com.example.admin.myapplication.mobel.vocabulary;

import java.io.File;
import java.io.FileOutputStream;

import java.io.InputStream;
import java.io.OutputStream;

import java.util.List;


/**
 * Created by Admin on 8/6/2559.
 */
public class detailactivity2 extends Activity {
    private ListView lvocabulary;
    private ListView lvocabulary1;
    private ShowVocabularyAdapter adapter;
    private ShowEng adapter1;
    private List<vocabulary> mVocabularyList;
    private DatabaseHalper mDBHelper;
    private ImageView soundth;
    private ImageView sounden;
    private int j=1;

    private int soundfileTH[]= new int[] {R.raw.th1,R.raw.th1,R.raw.th2,R.raw.th3,R.raw.th4,R.raw.th5,R.raw.th6,R.raw.th7,R.raw.th8,R.raw.th9,R.raw.th10
            ,R.raw.th11,R.raw.th12,R.raw.th13,R.raw.th14,R.raw.th15,R.raw.th16,R.raw.th17,R.raw.th18,R.raw.th19,R.raw.th20
            ,R.raw.th21,R.raw.th22,R.raw.th23,R.raw.th24,R.raw.th25,R.raw.th26,R.raw.th27,R.raw.th28,R.raw.th29,R.raw.th30
            ,R.raw.th31,R.raw.th32,R.raw.th33,R.raw.th34,R.raw.th35,R.raw.th36,R.raw.th37,R.raw.th38,R.raw.th39,R.raw.th40
            ,R.raw.th41,R.raw.th42,R.raw.th43,R.raw.th44,R.raw.th45,R.raw.th46,R.raw.th47,R.raw.th48,R.raw.th49,R.raw.th50
            ,R.raw.th51,R.raw.th52,R.raw.th53,R.raw.th54,R.raw.th55,R.raw.th56,R.raw.th57,R.raw.th58,R.raw.th59,R.raw.th60
            ,R.raw.th61,R.raw.th62,R.raw.th63,R.raw.th64,R.raw.th65,R.raw.th66,R.raw.th67,R.raw.th68,R.raw.th69,R.raw.th70
            ,R.raw.th71,R.raw.th72,R.raw.th73,R.raw.th74,R.raw.th75,R.raw.th76,R.raw.th77,R.raw.th78,R.raw.th79,R.raw.th80
            ,R.raw.th81,R.raw.th82,R.raw.th83,R.raw.th84,R.raw.th85,R.raw.th86,R.raw.th87,R.raw.th88,R.raw.th89,R.raw.th90
            ,R.raw.th91,R.raw.th92,R.raw.th93,R.raw.th94,R.raw.th95,R.raw.th96,R.raw.th97,R.raw.th98,R.raw.th99,R.raw.th100
            ,R.raw.th101,R.raw.th102,R.raw.th103,R.raw.th104,R.raw.th105,R.raw.th106,R.raw.th107,R.raw.th108,R.raw.th109,R.raw.th110
            ,R.raw.th111,R.raw.th112,R.raw.th113,R.raw.th114,R.raw.th115,R.raw.th116,R.raw.th117,R.raw.th118,R.raw.th119,R.raw.th120
            ,R.raw.th121,R.raw.th122,R.raw.th123,R.raw.th124,R.raw.th125,R.raw.th126,R.raw.th127,R.raw.th128,R.raw.th129,R.raw.th130
            ,R.raw.th131,R.raw.th132,R.raw.th133,R.raw.th134,R.raw.th135,R.raw.th136,R.raw.th137,R.raw.th138,R.raw.th139,R.raw.th140
            ,R.raw.th141,R.raw.th142,R.raw.th143,R.raw.th144,R.raw.th145,R.raw.th146,R.raw.th147,R.raw.th148,R.raw.th149,R.raw.th150
            ,R.raw.th151,R.raw.th152,R.raw.th153,R.raw.th154,R.raw.th155,R.raw.th156,R.raw.th157,R.raw.th158,R.raw.th159,R.raw.th160
            ,R.raw.th161,R.raw.th162,R.raw.th163,R.raw.th164,R.raw.th165,R.raw.th166,R.raw.th167,R.raw.th168,R.raw.th169,R.raw.th170
            ,R.raw.th171,R.raw.th172,R.raw.th173,R.raw.th174,R.raw.th175,R.raw.th176,R.raw.th177,R.raw.th178,R.raw.th179,R.raw.th180
            ,R.raw.th181,R.raw.th182,R.raw.th183,R.raw.th184,R.raw.th185,R.raw.th186,R.raw.th187,R.raw.th188,R.raw.th189,R.raw.th190
            ,R.raw.th191,R.raw.th192,R.raw.th193,R.raw.th194,R.raw.th195,R.raw.th196,R.raw.th197,R.raw.th198,R.raw.th199,R.raw.th200
            ,R.raw.th201,R.raw.th202,R.raw.th203,R.raw.th204,R.raw.th205,R.raw.th206,R.raw.th207,R.raw.th208,R.raw.th209,R.raw.th210
            ,R.raw.th211,R.raw.th212,R.raw.th213,R.raw.th214,R.raw.th215,R.raw.th216,R.raw.th217,R.raw.th218,R.raw.th219,R.raw.th220
            ,R.raw.th221,R.raw.th222,R.raw.th223,R.raw.th224,R.raw.th225,R.raw.th226,R.raw.th227,R.raw.th228,R.raw.th229,R.raw.th230
            ,R.raw.th231,R.raw.th232,R.raw.th233,R.raw.th234,R.raw.th235,R.raw.th236,R.raw.th237,R.raw.th238,R.raw.th239,R.raw.th240
            ,R.raw.th241,R.raw.th242,R.raw.th243,R.raw.th244,R.raw.th245,R.raw.th246,R.raw.th247,R.raw.th248,R.raw.th249,R.raw.th250
            ,R.raw.th251,R.raw.th252,R.raw.th253,R.raw.th254,R.raw.th255,R.raw.th256,R.raw.th257,R.raw.th258,R.raw.th259,R.raw.th260
            ,R.raw.th261,R.raw.th262,R.raw.th263,R.raw.th264,R.raw.th265,R.raw.th266,R.raw.th267,R.raw.th268,R.raw.th269,R.raw.th270
            ,R.raw.th271,R.raw.th272,R.raw.th273,R.raw.th274,R.raw.th275,R.raw.th276,R.raw.th277,R.raw.th278,R.raw.th279,R.raw.th280
            ,R.raw.th281,R.raw.th282,R.raw.th283,R.raw.th284,R.raw.th285,R.raw.th286,R.raw.th287,R.raw.th288,R.raw.th289,R.raw.th290
            ,R.raw.th291,R.raw.th292,R.raw.th293,R.raw.th294,R.raw.th295,R.raw.th296,R.raw.th297,R.raw.th298,R.raw.th299,R.raw.th300
            ,R.raw.th301,R.raw.th302,R.raw.th303,R.raw.th304,R.raw.th305,R.raw.th306,R.raw.th307,R.raw.th308,R.raw.th309,R.raw.th310
            ,R.raw.th311,R.raw.th312,R.raw.th313,R.raw.th314,R.raw.th315,R.raw.th316,R.raw.th317,R.raw.th318,R.raw.th319,R.raw.th320
            ,R.raw.th321,R.raw.th322,R.raw.th323,R.raw.th324,R.raw.th325,R.raw.th326,R.raw.th327,R.raw.th328,R.raw.th329,R.raw.th330
            ,R.raw.th331,R.raw.th332,R.raw.th333,R.raw.th334,R.raw.th335,R.raw.th336,R.raw.th337,R.raw.th338,R.raw.th339,R.raw.th340
            ,R.raw.th341,R.raw.th342,R.raw.th343,R.raw.th344,R.raw.th345,R.raw.th346,R.raw.th347,R.raw.th348,R.raw.th349,R.raw.th350
            ,R.raw.th351,R.raw.th352,R.raw.th353,R.raw.th354,R.raw.th355,R.raw.th356,R.raw.th357,R.raw.th358,R.raw.th359,R.raw.th360
            ,R.raw.th361,R.raw.th362,R.raw.th363,R.raw.th364,R.raw.th365,R.raw.th366,R.raw.th367,R.raw.th368,R.raw.th369,R.raw.th370
            ,R.raw.th371,R.raw.th372,R.raw.th373,R.raw.th374,R.raw.th375,R.raw.th376,R.raw.th377,R.raw.th378,R.raw.th379,R.raw.th380
            ,R.raw.th381,R.raw.th382,R.raw.th383,R.raw.th384,R.raw.th385,R.raw.th386,R.raw.th387,R.raw.th388,R.raw.th389,R.raw.th390
            ,R.raw.th391,R.raw.th392,R.raw.th393,R.raw.th394,R.raw.th395,R.raw.th396,R.raw.th397,R.raw.th398,R.raw.th399,R.raw.th400
            ,R.raw.th401,R.raw.th402,R.raw.th403,R.raw.th404,R.raw.th405,R.raw.th406,R.raw.th407,R.raw.th408,R.raw.th409,R.raw.th410
            ,R.raw.th411,R.raw.th412,R.raw.th413,R.raw.th414,R.raw.th415,R.raw.th416,R.raw.th417,R.raw.th418,R.raw.th419,R.raw.th420
            ,R.raw.th421,R.raw.th422,R.raw.th423,R.raw.th424,R.raw.th425,R.raw.th426,R.raw.th427,R.raw.th428,R.raw.th429,R.raw.th430
            ,R.raw.th431,R.raw.th432,R.raw.th433,R.raw.th434,R.raw.th435,R.raw.th436,R.raw.th437,R.raw.th438,R.raw.th439,R.raw.th440
            ,R.raw.th441,R.raw.th442,R.raw.th443,R.raw.th444,R.raw.th445,R.raw.th446,R.raw.th447,R.raw.th448,R.raw.th449,R.raw.th450
            ,R.raw.th451,R.raw.th452,R.raw.th453,R.raw.th454,R.raw.th455,R.raw.th456,R.raw.th457,R.raw.th458,R.raw.th459,R.raw.th460
            ,R.raw.th461,R.raw.th462,R.raw.th463,R.raw.th464,R.raw.th465,R.raw.th466,R.raw.th467,R.raw.th468,R.raw.th469,R.raw.th470
            ,R.raw.th471,R.raw.th472,R.raw.th473,R.raw.th474,R.raw.th475,R.raw.th476,R.raw.th477,R.raw.th478,R.raw.th479,R.raw.th480
            ,R.raw.th481,R.raw.th482,R.raw.th483,R.raw.th484,R.raw.th485,R.raw.th486,R.raw.th487,R.raw.th488,R.raw.th489,R.raw.th490
            ,R.raw.th491,R.raw.th492,R.raw.th493,R.raw.th494,R.raw.th495,R.raw.th496,R.raw.th497,R.raw.th498,R.raw.th499,R.raw.th500
            ,R.raw.th501,R.raw.th502,R.raw.th503,R.raw.th504,R.raw.th505,R.raw.th506,R.raw.th507,R.raw.th508,R.raw.th509,R.raw.th510
            ,R.raw.th511,R.raw.th512,R.raw.th513,R.raw.th514,R.raw.th515,R.raw.th516,R.raw.th517,R.raw.th518,R.raw.th519,R.raw.th520
            ,R.raw.th521,R.raw.th522,R.raw.th523,R.raw.th524,R.raw.th525,R.raw.th526,R.raw.th527,R.raw.th528,R.raw.th529,R.raw.th530
            ,R.raw.th531,R.raw.th532,R.raw.th533,R.raw.th534,R.raw.th535,R.raw.th536,R.raw.th537,R.raw.th538,R.raw.th539,R.raw.th540
            ,R.raw.th541,R.raw.th542,R.raw.th543,R.raw.th544,R.raw.th545,R.raw.th546,R.raw.th547,R.raw.th548,R.raw.th549,R.raw.th550
            ,R.raw.th551,R.raw.th552,R.raw.th553,R.raw.th554,R.raw.th555,R.raw.th556,R.raw.th557,R.raw.th558,R.raw.th559,R.raw.th560
            ,R.raw.th561,R.raw.th562,R.raw.th563,R.raw.th564,R.raw.th565,R.raw.th566,R.raw.th567,R.raw.th568,R.raw.th569,R.raw.th570
            ,R.raw.th571,R.raw.th572,R.raw.th573,R.raw.th574,R.raw.th575,R.raw.th576,R.raw.th577,R.raw.th578,R.raw.th579,R.raw.th580
            ,R.raw.th581,R.raw.th582,R.raw.th583,R.raw.th584,R.raw.th585,R.raw.th586,R.raw.th587,R.raw.th588,R.raw.th589,R.raw.th590
            ,R.raw.th591,R.raw.th592,R.raw.th593,R.raw.th594,R.raw.th595,R.raw.th596,R.raw.th597,R.raw.th598,R.raw.th599,R.raw.th600
            ,R.raw.th601,R.raw.th602,R.raw.th603,R.raw.th604,R.raw.th605,R.raw.th606,R.raw.th607,R.raw.th608,R.raw.th609,R.raw.th610
            ,R.raw.th611,R.raw.th612,R.raw.th613,R.raw.th614,R.raw.th615,R.raw.th616,R.raw.th617,R.raw.th618,R.raw.th619,R.raw.th620
            ,R.raw.th621,R.raw.th622,R.raw.th623,R.raw.th624,R.raw.th625,R.raw.th626,R.raw.th627,R.raw.th628,R.raw.th629,R.raw.th630
            ,R.raw.th631,R.raw.th632,R.raw.th633,R.raw.th634,R.raw.th635,R.raw.th636,R.raw.th637,R.raw.th638,R.raw.th639,R.raw.th640
            ,R.raw.th641,R.raw.th642,R.raw.th643,R.raw.th644,R.raw.th645,R.raw.th646,R.raw.th647,R.raw.th648,R.raw.th649,R.raw.th650
            ,R.raw.th651,R.raw.th652,R.raw.th653,R.raw.th654,R.raw.th655,R.raw.th656,R.raw.th657,R.raw.th658,R.raw.th659,R.raw.th660
            ,R.raw.th661,R.raw.th662,R.raw.th663,R.raw.th664,R.raw.th665,R.raw.th666,R.raw.th667,R.raw.th668,R.raw.th669,R.raw.th670
            ,R.raw.th671,R.raw.th672,R.raw.th673,R.raw.th674,R.raw.th675,R.raw.th676,R.raw.th677,R.raw.th678,R.raw.th679,R.raw.th680
            ,R.raw.th681,R.raw.th682,R.raw.th683,R.raw.th684,R.raw.th685,R.raw.th686,R.raw.th687,R.raw.th688,R.raw.th689,R.raw.th690
            ,R.raw.th691,R.raw.th692,R.raw.th693,R.raw.th694,R.raw.th695,R.raw.th696,R.raw.th697,R.raw.th698,R.raw.th699,R.raw.th700
            ,R.raw.th701,R.raw.th702,R.raw.th703,R.raw.th704,R.raw.th705,R.raw.th706,R.raw.th707,R.raw.th708,R.raw.th709,R.raw.th710
            ,R.raw.th711,R.raw.th712,R.raw.th713,R.raw.th714,R.raw.th715,R.raw.th716,R.raw.th717,R.raw.th718,R.raw.th719,R.raw.th720
            ,R.raw.th721,R.raw.th722,R.raw.th723,R.raw.th724,R.raw.th725,R.raw.th726,R.raw.th727,R.raw.th728,R.raw.th729,R.raw.th730
            ,R.raw.th731,R.raw.th732,R.raw.th733,R.raw.th734,R.raw.th735,R.raw.th736,R.raw.th737,R.raw.th738,R.raw.th739,R.raw.th740
            ,R.raw.th741,R.raw.th742,R.raw.th743,R.raw.th744,R.raw.th745,R.raw.th746,R.raw.th747,R.raw.th748,R.raw.th749,R.raw.th750
            ,R.raw.th751,R.raw.th752,R.raw.th753,R.raw.th754,R.raw.th755,R.raw.th756,R.raw.th757,R.raw.th758,R.raw.th759,R.raw.th760
            ,R.raw.th761,R.raw.th762,R.raw.th763,R.raw.th764,R.raw.th765,R.raw.th766,R.raw.th767,R.raw.th768,R.raw.th769,R.raw.th770
            ,R.raw.th771,R.raw.th772,R.raw.th773,R.raw.th774,R.raw.th775,R.raw.th776,R.raw.th777,R.raw.th778,R.raw.th779,R.raw.th780
            ,R.raw.th781,R.raw.th782,R.raw.th783,R.raw.th784,R.raw.th785,R.raw.th786,R.raw.th787,R.raw.th788,R.raw.th789,R.raw.th790
            ,R.raw.th791,R.raw.th792,R.raw.th793,R.raw.th794,R.raw.th795,R.raw.th796,R.raw.th797,R.raw.th798,R.raw.th799,R.raw.th800
            ,R.raw.th801,R.raw.th802,R.raw.th803,R.raw.th804,R.raw.th805,R.raw.th806,R.raw.th807,R.raw.th808,R.raw.th809,R.raw.th810
            ,R.raw.th811,R.raw.th812,R.raw.th813,R.raw.th814,R.raw.th815,R.raw.th816,R.raw.th817,R.raw.th818,R.raw.th819,R.raw.th820
            ,R.raw.th821,R.raw.th822,R.raw.th823,R.raw.th824,R.raw.th825,R.raw.th826,R.raw.th827,R.raw.th828,R.raw.th829,R.raw.th830
            ,R.raw.th831,R.raw.th832,R.raw.th833,R.raw.th834,R.raw.th835,R.raw.th836,R.raw.th837,R.raw.th838,R.raw.th839,R.raw.th840
            ,R.raw.th841,R.raw.th842,R.raw.th843,R.raw.th844,R.raw.th845,R.raw.th846,R.raw.th847,R.raw.th848,R.raw.th849,R.raw.th850
            ,R.raw.th851,R.raw.th852,R.raw.th853,R.raw.th854,R.raw.th855,R.raw.th856,R.raw.th857,R.raw.th858,R.raw.th859,R.raw.th860
            ,R.raw.th861,R.raw.th862,R.raw.th863,R.raw.th864,R.raw.th865,R.raw.th866,R.raw.th867,R.raw.th868,R.raw.th869,R.raw.th870
            ,R.raw.th871,R.raw.th872,R.raw.th873,R.raw.th874,R.raw.th875,R.raw.th876,R.raw.th877,R.raw.th878,R.raw.th879,R.raw.th880
            ,R.raw.th881,R.raw.th882,R.raw.th883,R.raw.th884,R.raw.th885,R.raw.th886,R.raw.th887,R.raw.th888,R.raw.th889,R.raw.th890
            ,R.raw.th891,R.raw.th892,R.raw.th893,R.raw.th894,R.raw.th895,R.raw.th896,R.raw.th897,R.raw.th898,R.raw.th899,R.raw.th900
            ,R.raw.th901,R.raw.th902,R.raw.th903,R.raw.th904,R.raw.th905,R.raw.th906,R.raw.th907,R.raw.th908,R.raw.th909,R.raw.th910
            ,R.raw.th911,R.raw.th912,R.raw.th913,R.raw.th914,R.raw.th915,R.raw.th916,R.raw.th917,R.raw.th918,R.raw.th919,R.raw.th920
            ,R.raw.th921,R.raw.th922,R.raw.th923,R.raw.th924,R.raw.th925,R.raw.th926,R.raw.th927,R.raw.th928,R.raw.th929,R.raw.th930
            ,R.raw.th931,R.raw.th932,R.raw.th933,R.raw.th934,R.raw.th935,R.raw.th936,R.raw.th937,R.raw.th938,R.raw.th939,R.raw.th940
            ,R.raw.th941,R.raw.th942,R.raw.th943,R.raw.th944,R.raw.th945,R.raw.th946,R.raw.th947,R.raw.th948,R.raw.th949,R.raw.th950
            ,R.raw.th951,R.raw.th952,R.raw.th953,R.raw.th954,R.raw.th955,R.raw.th956,R.raw.th957,R.raw.th958,R.raw.th959,R.raw.th960
            ,R.raw.th961,R.raw.th962,R.raw.th963,R.raw.th964,R.raw.th965,R.raw.th966,R.raw.th967,R.raw.th968,R.raw.th969,R.raw.th970
            ,R.raw.th971,R.raw.th972,R.raw.th973,R.raw.th974,R.raw.th975,R.raw.th976,R.raw.th977,R.raw.th978,R.raw.th979,R.raw.th980
            ,R.raw.th981,R.raw.th982,R.raw.th983,R.raw.th984,R.raw.th985,R.raw.th986,R.raw.th987,R.raw.th988,R.raw.th989,R.raw.th990
            ,R.raw.th991,R.raw.th992,R.raw.th993,R.raw.th994,R.raw.th995,R.raw.th996,R.raw.th997,R.raw.th998,R.raw.th999,R.raw.th1000
            ,R.raw.th1001,R.raw.th1002,R.raw.th1003,R.raw.th1004,R.raw.th1005,R.raw.th1006,R.raw.th1007,R.raw.th1008,R.raw.th1009,R.raw.th1010
            ,R.raw.th1011,R.raw.th1012,R.raw.th1013,R.raw.th1014,R.raw.th1015,R.raw.th1016,R.raw.th1017,R.raw.th1018,R.raw.th1019,R.raw.th1020
            ,R.raw.th1021,R.raw.th1022,R.raw.th1023,R.raw.th1024,R.raw.th1025,R.raw.th1026,R.raw.th1027,R.raw.th1028,R.raw.th1029,R.raw.th1030
            ,R.raw.th1031,R.raw.th1032,R.raw.th1033,R.raw.th1034,R.raw.th1035,R.raw.th1036,R.raw.th1037,R.raw.th1038,R.raw.th1039,R.raw.th1040
            ,R.raw.th1041,R.raw.th1042,R.raw.th1043,R.raw.th1044,R.raw.th1045,R.raw.th1046,R.raw.th1047,R.raw.th1048,R.raw.th1049,R.raw.th1050
            ,R.raw.th1051,R.raw.th1052,R.raw.th1053,R.raw.th1054,R.raw.th1055,R.raw.th1056,R.raw.th1057,R.raw.th1058,R.raw.th1059,R.raw.th1060
            ,R.raw.th1061,R.raw.th1062,R.raw.th1063,R.raw.th1064,R.raw.th1065,R.raw.th1066,R.raw.th1067,R.raw.th1068,R.raw.th1069,R.raw.th1070
            ,R.raw.th1071,R.raw.th1072,R.raw.th1073,R.raw.th1074,R.raw.th1075,R.raw.th1076,R.raw.th1077,R.raw.th1078,R.raw.th1079,R.raw.th1080
            ,R.raw.th1081,R.raw.th1082,R.raw.th1083,R.raw.th1084,R.raw.th1085,R.raw.th1086,R.raw.th1087,R.raw.th1088,R.raw.th1089,R.raw.th1090
            ,R.raw.th1091,R.raw.th1092,R.raw.th1093,R.raw.th1094,R.raw.th1095,R.raw.th1096,R.raw.th1097,R.raw.th1098,R.raw.th1099,R.raw.th1100
            ,R.raw.th1101,R.raw.th1102,R.raw.th1103,R.raw.th1104,R.raw.th1105,R.raw.th1106,R.raw.th1107,R.raw.th1108,R.raw.th1109,R.raw.th1110
            ,R.raw.th1111,R.raw.th1112,R.raw.th1113,R.raw.th1114,R.raw.th1115,R.raw.th1116,R.raw.th1117,R.raw.th1118,R.raw.th1119,R.raw.th1120
            ,R.raw.th1121,R.raw.th1122,R.raw.th1123,R.raw.th1124,R.raw.th1125,R.raw.th1126,R.raw.th1127,R.raw.th1128,R.raw.th1129,R.raw.th1130
            ,R.raw.th1131,R.raw.th1132,R.raw.th1133,R.raw.th1134,R.raw.th1135,R.raw.th1136,R.raw.th1137,R.raw.th1138,R.raw.th1139,R.raw.th1140
            ,R.raw.th1141,R.raw.th1142,R.raw.th1143,R.raw.th1144,R.raw.th1145,R.raw.th1146,R.raw.th1147,R.raw.th1148,R.raw.th1149,R.raw.th1150
            ,R.raw.th1151,R.raw.th1152,R.raw.th1153,R.raw.th1154,R.raw.th1155,R.raw.th1156,R.raw.th1157,R.raw.th1158,R.raw.th1159,R.raw.th1160
            ,R.raw.th1161,R.raw.th1162,R.raw.th1163,R.raw.th1164,R.raw.th1165,R.raw.th1166,R.raw.th1167,R.raw.th1168,R.raw.th1169,R.raw.th1170
            ,R.raw.th1171,R.raw.th1172,R.raw.th1173,R.raw.th1174,R.raw.th1175,R.raw.th1176,R.raw.th1177,R.raw.th1178,R.raw.th1179,R.raw.th1180
            ,R.raw.th1181,R.raw.th1182,R.raw.th1183,R.raw.th1184,R.raw.th1185,R.raw.th1186,R.raw.th1187,R.raw.th1188,R.raw.th1189,R.raw.th1190
            ,R.raw.th1191,R.raw.th1192,R.raw.th1193,R.raw.th1194,R.raw.th1195,R.raw.th1196,R.raw.th1197,R.raw.th1198,R.raw.th1199,R.raw.th1200
            ,R.raw.th1201,R.raw.th1202,R.raw.th1203,R.raw.th1204,R.raw.th1205,R.raw.th1206,R.raw.th1207,R.raw.th1208,R.raw.th1209,R.raw.th1210
            ,R.raw.th1211,R.raw.th1212,R.raw.th1213,R.raw.th1214,R.raw.th1215,R.raw.th1216,R.raw.th1217,R.raw.th1218,R.raw.th1219,R.raw.th1220
            ,R.raw.th1221,R.raw.th1222,R.raw.th1223,R.raw.th1224,R.raw.th1225,R.raw.th1226,R.raw.th1227,R.raw.th1228,R.raw.th1229,R.raw.th1230
            ,R.raw.th1231,R.raw.th1232,R.raw.th1233,R.raw.th1234,R.raw.th1235,R.raw.th1236,R.raw.th1237,R.raw.th1238,R.raw.th1239,R.raw.th1240
            ,R.raw.th1241,R.raw.th1242,R.raw.th1243,R.raw.th1244,R.raw.th1245,R.raw.th1246,R.raw.th1247,R.raw.th1248,R.raw.th1249,R.raw.th1250
            ,R.raw.th1251,R.raw.th1252,R.raw.th1253,R.raw.th1254,R.raw.th1255,R.raw.th1256,R.raw.th1257,R.raw.th1258,R.raw.th1259,R.raw.th1260
            ,R.raw.th1261,R.raw.th1262,R.raw.th1263,R.raw.th1264,R.raw.th1265,R.raw.th1266,R.raw.th1267,R.raw.th1268,R.raw.th1269,R.raw.th1270
            ,R.raw.th1271,R.raw.th1272,R.raw.th1273,R.raw.th1274,R.raw.th1275,R.raw.th1276,R.raw.th1277,R.raw.th1278,R.raw.th1279,R.raw.th1280
            ,R.raw.th1281,R.raw.th1282,R.raw.th1283,R.raw.th1284,R.raw.th1285,R.raw.th1286,R.raw.th1287,R.raw.th1288,R.raw.th1289,R.raw.th1290
            ,R.raw.th1291,R.raw.th1292,R.raw.th1293,R.raw.th1294,R.raw.th1295,R.raw.th1296,R.raw.th1297,R.raw.th1298,R.raw.th1299,R.raw.th1300
            ,R.raw.th1301,R.raw.th1302,R.raw.th1303,R.raw.th1304,R.raw.th1305,R.raw.th1306,R.raw.th1307,R.raw.th1308,R.raw.th1309,R.raw.th1310
            ,R.raw.th1311,R.raw.th1312,R.raw.th1313,R.raw.th1314,R.raw.th1315,R.raw.th1316,R.raw.th1317,R.raw.th1318,R.raw.th1319,R.raw.th1320
            ,R.raw.th1321,R.raw.th1322,R.raw.th1323,R.raw.th1324,R.raw.th1325,R.raw.th1326,R.raw.th1327,R.raw.th1328,R.raw.th1329,R.raw.th1330
            ,R.raw.th1331,R.raw.th1332,R.raw.th1333,R.raw.th1334,R.raw.th1335,R.raw.th1336,R.raw.th1337,R.raw.th1338,R.raw.th1339,R.raw.th1340
            ,R.raw.th1341,R.raw.th1342,R.raw.th1343,R.raw.th1344,R.raw.th1345,R.raw.th1346,R.raw.th1347,R.raw.th1348,R.raw.th1349,R.raw.th1350
            ,R.raw.th1351,R.raw.th1352,R.raw.th1353,R.raw.th1354,R.raw.th1355,R.raw.th1356,R.raw.th1357,R.raw.th1358,R.raw.th1359,R.raw.th1360
            ,R.raw.th1361,R.raw.th1362,R.raw.th1363,R.raw.th1364,R.raw.th1365,R.raw.th1366,R.raw.th1367,R.raw.th1368,R.raw.th1369,R.raw.th1370
            ,R.raw.th1371,R.raw.th1372,R.raw.th1373,R.raw.th1374,R.raw.th1375,R.raw.th1376,R.raw.th1377,R.raw.th1378,R.raw.th1379,R.raw.th1380
            ,R.raw.th1381,R.raw.th1382,R.raw.th1383,R.raw.th1384,R.raw.th1385,R.raw.th1386,R.raw.th1387,R.raw.th1388,R.raw.th1389,R.raw.th1390
            ,R.raw.th1391,R.raw.th1392,R.raw.th1393,R.raw.th1394,R.raw.th1395,R.raw.th1396,R.raw.th1397,R.raw.th1398,R.raw.th1399,R.raw.th1400
            ,R.raw.th1401,R.raw.th1402,R.raw.th1403,R.raw.th1404,R.raw.th1405,R.raw.th1406,R.raw.th1407,R.raw.th1408,R.raw.th1409,R.raw.th1410
            ,R.raw.th1411,R.raw.th1412,R.raw.th1413,R.raw.th1414,R.raw.th1415,R.raw.th1416,R.raw.th1417,R.raw.th1418,R.raw.th1419,R.raw.th1420
            ,R.raw.th1421,R.raw.th1422,R.raw.th1423,R.raw.th1424,R.raw.th1425,R.raw.th1426,R.raw.th1427,R.raw.th1428,R.raw.th1429,R.raw.th1430
            ,R.raw.th1431,R.raw.th1432,R.raw.th1433,R.raw.th1434,R.raw.th1435,R.raw.th1436,R.raw.th1437,R.raw.th1438,R.raw.th1439,R.raw.th1440
            ,R.raw.th1441,R.raw.th1442,R.raw.th1443,R.raw.th1444,R.raw.th1445,R.raw.th1446,R.raw.th1447,R.raw.th1448,R.raw.th1449,R.raw.th1450
            ,R.raw.th1451,R.raw.th1452,R.raw.th1453,R.raw.th1454,R.raw.th1455,R.raw.th1456,R.raw.th1457,R.raw.th1458,R.raw.th1459,R.raw.th1460
            ,R.raw.th1461,R.raw.th1462,R.raw.th1463,R.raw.th1464,R.raw.th1465,R.raw.th1466,R.raw.th1467,R.raw.th1468,R.raw.th1469,R.raw.th1470
            ,R.raw.th1471,R.raw.th1472,R.raw.th1473,R.raw.th1474,R.raw.th1475,R.raw.th1476,R.raw.th1477,R.raw.th1478,R.raw.th1479,R.raw.th1480
            ,R.raw.th1481,R.raw.th1482,R.raw.th1483,R.raw.th1484,R.raw.th1485,R.raw.th1486,R.raw.th1487,R.raw.th1488,R.raw.th1489,R.raw.th1490
            ,R.raw.th1491,R.raw.th1492,R.raw.th1493,R.raw.th1494,R.raw.th1495,R.raw.th1496,R.raw.th1497,R.raw.th1498,R.raw.th1499,R.raw.th1500
            ,R.raw.th1501,R.raw.th1502,R.raw.th1503,R.raw.th1504,R.raw.th1505,R.raw.th1506,R.raw.th1507,R.raw.th1508,R.raw.th1509,R.raw.th1510
            ,R.raw.th1511,R.raw.th1512,R.raw.th1513,R.raw.th1514,R.raw.th1515,R.raw.th1516,R.raw.th1517,R.raw.th1518,R.raw.th1519,R.raw.th1520
            ,R.raw.th1521,R.raw.th1522,R.raw.th1523,R.raw.th1524,R.raw.th1525,R.raw.th1526,R.raw.th1527,R.raw.th1528,R.raw.th1529,R.raw.th1530
            ,R.raw.th1531,R.raw.th1532,R.raw.th1533,R.raw.th1534,R.raw.th1535,R.raw.th1536,R.raw.th1537,R.raw.th1538,R.raw.th1539,R.raw.th1540
            ,R.raw.th1541,R.raw.th1542,R.raw.th1543,R.raw.th1544,R.raw.th1545,R.raw.th1546,R.raw.th1547,R.raw.th1548,R.raw.th1549,R.raw.th1550
            ,R.raw.th1551,R.raw.th1552,R.raw.th1553,R.raw.th1554,R.raw.th1555,R.raw.th1556,R.raw.th1557,R.raw.th1558,R.raw.th1559,R.raw.th1560
            ,R.raw.th1561,R.raw.th1562,R.raw.th1563,R.raw.th1564,R.raw.th1565,R.raw.th1566,R.raw.th1567,R.raw.th1568,R.raw.th1569,R.raw.th1570
            ,R.raw.th1571,R.raw.th1572,R.raw.th1573,R.raw.th1574,R.raw.th1575,R.raw.th1576,R.raw.th1577,R.raw.th1578,R.raw.th1579,R.raw.th1580
            ,R.raw.th1581,R.raw.th1582,R.raw.th1583,R.raw.th1584,R.raw.th1585,R.raw.th1586,R.raw.th1587,R.raw.th1588,R.raw.th1589,R.raw.th1590
            ,R.raw.th1591,R.raw.th1592,R.raw.th1593,R.raw.th1594,R.raw.th1595,R.raw.th1596,R.raw.th1597,R.raw.th1598,R.raw.th1599,R.raw.th1600
            ,R.raw.th1601,R.raw.th1602,R.raw.th1603,R.raw.th1604,R.raw.th1605,R.raw.th1606,R.raw.th1607,R.raw.th1608,R.raw.th1609,R.raw.th1610
            ,R.raw.th1611,R.raw.th1612,R.raw.th1613,R.raw.th1614,R.raw.th1615,R.raw.th1616,R.raw.th1617,R.raw.th1618,R.raw.th1619,R.raw.th1620
            ,R.raw.th1621,R.raw.th1622,R.raw.th1623,R.raw.th1624,R.raw.th1625,R.raw.th1626,R.raw.th1627,R.raw.th1628,R.raw.th1629,R.raw.th1630
            ,R.raw.th1631,R.raw.th1632,R.raw.th1633,R.raw.th1634,R.raw.th1635,R.raw.th1636,R.raw.th1637,R.raw.th1638,R.raw.th1639,R.raw.th1640
            ,R.raw.th1641,R.raw.th1642,R.raw.th1643,R.raw.th1644,R.raw.th1645,R.raw.th1646,R.raw.th1647,R.raw.th1648,R.raw.th1649,R.raw.th1650
            ,R.raw.th1651,R.raw.th1652,R.raw.th1653,R.raw.th1654,R.raw.th1655,R.raw.th1656,R.raw.th1657,R.raw.th1658,R.raw.th1659,R.raw.th1660
            ,R.raw.th1661,R.raw.th1662,R.raw.th1663,R.raw.th1664,R.raw.th1665,R.raw.th1666,R.raw.th1667,R.raw.th1668,R.raw.th1669,R.raw.th1670
            ,R.raw.th1671,R.raw.th1672,R.raw.th1673,R.raw.th1674,R.raw.th1675,R.raw.th1676,R.raw.th1677,R.raw.th1678,R.raw.th1679,R.raw.th1680
            ,R.raw.th1681,R.raw.th1682,R.raw.th1683,R.raw.th1684,R.raw.th1685,R.raw.th1686,R.raw.th1687,R.raw.th1688,R.raw.th1689,R.raw.th1690
            ,R.raw.th1691,R.raw.th1692,R.raw.th1693,R.raw.th1694,R.raw.th1695,R.raw.th1696,R.raw.th1697,R.raw.th1698,R.raw.th1699,R.raw.th1700
            ,R.raw.th1701,R.raw.th1702,R.raw.th1703,R.raw.th1704,R.raw.th1705,R.raw.th1706,R.raw.th1707,R.raw.th1708,R.raw.th1709,R.raw.th1710
            ,R.raw.th1711,R.raw.th1712,R.raw.th1713,R.raw.th1714,R.raw.th1715,R.raw.th1716,R.raw.th1717,R.raw.th1718,R.raw.th1719,R.raw.th1720
            ,R.raw.th1721,R.raw.th1722,R.raw.th1723,R.raw.th1724,R.raw.th1725,R.raw.th1726,R.raw.th1727,R.raw.th1728,R.raw.th1729,R.raw.th1730
            ,R.raw.th1731,R.raw.th1732,R.raw.th1733,R.raw.th1734,R.raw.th1735,R.raw.th1736,R.raw.th1737,R.raw.th1738,R.raw.th1739,R.raw.th1740
            ,R.raw.th1741,R.raw.th1742,R.raw.th1743,R.raw.th1744,R.raw.th1745,R.raw.th1746,R.raw.th1747,R.raw.th1748,R.raw.th1749,R.raw.th1750
            ,R.raw.th1751,R.raw.th1752,R.raw.th1753,R.raw.th1754,R.raw.th1755,R.raw.th1756,R.raw.th1757,R.raw.th1758,R.raw.th1759,R.raw.th1760
            ,R.raw.th1761,R.raw.th1762,R.raw.th1763,R.raw.th1764,R.raw.th1765,R.raw.th1766,R.raw.th1767,R.raw.th1768,R.raw.th1769,R.raw.th1770
            ,R.raw.th1771,R.raw.th1772,R.raw.th1773,R.raw.th1774,R.raw.th1775,R.raw.th1776,R.raw.th1777,R.raw.th1778,R.raw.th1779,R.raw.th1780
            ,R.raw.th1781,R.raw.th1782,R.raw.th1783,R.raw.th1784,R.raw.th1785,R.raw.th1786,R.raw.th1787,R.raw.th1788,R.raw.th1789,R.raw.th1790
            ,R.raw.th1791,R.raw.th1792,R.raw.th1793,R.raw.th1794,R.raw.th1795,R.raw.th1796,R.raw.th1797,R.raw.th1798,R.raw.th1799,R.raw.th1800
            ,R.raw.th1801,R.raw.th1802,R.raw.th1803,R.raw.th1804,R.raw.th1805,R.raw.th1806,R.raw.th1807,R.raw.th1808,R.raw.th1809,R.raw.th1810
            ,R.raw.th1811,R.raw.th1812,R.raw.th1813,R.raw.th1814,R.raw.th1815,R.raw.th1816,R.raw.th1817,R.raw.th1818,R.raw.th1819,R.raw.th1820
            ,R.raw.th1821,R.raw.th1822,R.raw.th1823,R.raw.th1824,R.raw.th1825,R.raw.th1826,R.raw.th1827,R.raw.th1828,R.raw.th1829,R.raw.th1830
            ,R.raw.th1831,R.raw.th1832,R.raw.th1833,R.raw.th1834,R.raw.th1835,R.raw.th1836,R.raw.th1837,R.raw.th1838,R.raw.th1839,R.raw.th1840
            ,R.raw.th1841,R.raw.th1842,R.raw.th1843,R.raw.th1844,R.raw.th1845,R.raw.th1846,R.raw.th1847,R.raw.th1848,R.raw.th1849,R.raw.th1850
            ,R.raw.th1851,R.raw.th1852,R.raw.th1853,R.raw.th1854,R.raw.th1855,R.raw.th1856,R.raw.th1857,R.raw.th1858,R.raw.th1859,R.raw.th1860
            ,R.raw.th1861,R.raw.th1862,R.raw.th1863,R.raw.th1864,R.raw.th1865,R.raw.th1866,R.raw.th1867,R.raw.th1868,R.raw.th1869,R.raw.th1870
            ,R.raw.th1871,R.raw.th1872,R.raw.th1873,R.raw.th1874,R.raw.th1875,R.raw.th1876,R.raw.th1877,R.raw.th1878,R.raw.th1879,R.raw.th1880
            ,R.raw.th1881,R.raw.th1882,R.raw.th1883,R.raw.th1884,R.raw.th1885,R.raw.th1886,R.raw.th1887,R.raw.th1888,R.raw.th1889,R.raw.th1890
            ,R.raw.th1891,R.raw.th1892,R.raw.th1893,R.raw.th1894,R.raw.th1895,R.raw.th1896,R.raw.th1897,R.raw.th1898,R.raw.th1899,R.raw.th1900
            ,R.raw.th1901,R.raw.th1902,R.raw.th1903,R.raw.th1904,R.raw.th1905,R.raw.th1906,R.raw.th1907,R.raw.th1908,R.raw.th1909,R.raw.th1910
            ,R.raw.th1911,R.raw.th1912,R.raw.th1913,R.raw.th1914,R.raw.th1915,R.raw.th1916,R.raw.th1917,R.raw.th1918,R.raw.th1919,R.raw.th1920
            ,R.raw.th1921,R.raw.th1922,R.raw.th1923,R.raw.th1924,R.raw.th1925,R.raw.th1926,R.raw.th1927,R.raw.th1928,R.raw.th1929,R.raw.th1930
            ,R.raw.th1931,R.raw.th1932,R.raw.th1933,R.raw.th1934,R.raw.th1935,R.raw.th1936,R.raw.th1937,R.raw.th1938,R.raw.th1939,R.raw.th1940
            ,R.raw.th1941,R.raw.th1942,R.raw.th1943,R.raw.th1944,R.raw.th1945,R.raw.th1946,R.raw.th1947,R.raw.th1948,R.raw.th1949,R.raw.th1950
            ,R.raw.th1951,R.raw.th1952,R.raw.th1953,R.raw.th1954,R.raw.th1955,R.raw.th1956,R.raw.th1957,R.raw.th1958,R.raw.th1959,R.raw.th1960
            ,R.raw.th1961,R.raw.th1962,R.raw.th1963,R.raw.th1964,R.raw.th1965,R.raw.th1966,R.raw.th1967,R.raw.th1968,R.raw.th1969,R.raw.th1970
            ,R.raw.th1971,R.raw.th1972,R.raw.th1973,R.raw.th1974,R.raw.th1975,R.raw.th1976,R.raw.th1977,R.raw.th1978,R.raw.th1979,R.raw.th1980
            ,R.raw.th1981,R.raw.th1982,R.raw.th1983,R.raw.th1984,R.raw.th1985,R.raw.th1986,R.raw.th1987,R.raw.th1988,R.raw.th1989,R.raw.th1990
            ,R.raw.th1991,R.raw.th1992,R.raw.th1993,R.raw.th1994,R.raw.th1995,R.raw.th1996,R.raw.th1997,R.raw.th1998,R.raw.th1999,R.raw.th2000
            ,R.raw.th2001,R.raw.th2002,R.raw.th2003,R.raw.th2004,R.raw.th2005,R.raw.th2006,R.raw.th2007,R.raw.th2008,R.raw.th2009,R.raw.th2010
            ,R.raw.th2011,R.raw.th2012,R.raw.th2013,R.raw.th2014,R.raw.th2015,R.raw.th2016,R.raw.th2017,R.raw.th2018,R.raw.th2019,R.raw.th2020
            ,R.raw.th2021,R.raw.th2022,R.raw.th2023,R.raw.th2024,R.raw.th2025,R.raw.th2026,R.raw.th2027,R.raw.th2028,R.raw.th2029,R.raw.th2030
            ,R.raw.th2031,R.raw.th2032,R.raw.th2033,R.raw.th2034,R.raw.th2035,R.raw.th2036,R.raw.th2037,R.raw.th2038,R.raw.th2039,R.raw.th2040
            ,R.raw.th2041,R.raw.th2042,R.raw.th2043,R.raw.th2044,R.raw.th2045,R.raw.th2046,R.raw.th2047,R.raw.th2048,R.raw.th2049,R.raw.th2050
            ,R.raw.th2051,R.raw.th2052,R.raw.th2053,R.raw.th2054,R.raw.th2055,R.raw.th2056,R.raw.th2057,R.raw.th2058,R.raw.th2059,R.raw.th2060
            ,R.raw.th2061,R.raw.th2062,R.raw.th2063,R.raw.th2064,R.raw.th2065,R.raw.th2066,R.raw.th2067,R.raw.th2068,R.raw.th2069,R.raw.th2070
            ,R.raw.th2071,R.raw.th2072,R.raw.th2073,R.raw.th2074,R.raw.th2075,R.raw.th2076,R.raw.th2077,R.raw.th2078,R.raw.th2079,R.raw.th2080
            ,R.raw.th2081,R.raw.th2082,R.raw.th2083,R.raw.th2084,R.raw.th2085,R.raw.th2086,R.raw.th2087,R.raw.th2088,R.raw.th2089,R.raw.th2090
            ,R.raw.th2091,R.raw.th2092,R.raw.th2093,R.raw.th2094,R.raw.th2095,R.raw.th2096,R.raw.th2097,R.raw.th2098,R.raw.th2099,R.raw.th2100
            ,R.raw.th2101,R.raw.th2102,R.raw.th2103,R.raw.th2104,R.raw.th2105,R.raw.th2106,R.raw.th2107,R.raw.th2108,R.raw.th2109,R.raw.th2110
            ,R.raw.th2111,R.raw.th2112,R.raw.th2113,R.raw.th2114,R.raw.th2115,R.raw.th2116,R.raw.th2117,R.raw.th2118,R.raw.th2119,R.raw.th2120
            ,R.raw.th2121,R.raw.th2122,R.raw.th2123,R.raw.th2124,R.raw.th2125,R.raw.th2126,R.raw.th2127,R.raw.th2128,R.raw.th2129,R.raw.th2130
            ,R.raw.th2131,R.raw.th2132,R.raw.th2133,R.raw.th2134,R.raw.th2135,R.raw.th2136,R.raw.th2137,R.raw.th2138,R.raw.th2139,R.raw.th2140
            ,R.raw.th2141,R.raw.th2142,R.raw.th2143,R.raw.th2144,R.raw.th2145,R.raw.th2146,R.raw.th2147,R.raw.th2148,R.raw.th2149,R.raw.th2150
            ,R.raw.th2151,R.raw.th2152,R.raw.th2153,R.raw.th2154,R.raw.th2155,R.raw.th2156,R.raw.th2157,R.raw.th2158,R.raw.th2159,R.raw.th2160
            ,R.raw.th2161,R.raw.th2162,R.raw.th2163,R.raw.th2164,R.raw.th2165,R.raw.th2166,R.raw.th2167,R.raw.th2168,R.raw.th2169,R.raw.th2170
            ,R.raw.th2171,R.raw.th2172,R.raw.th2173,R.raw.th2174,R.raw.th2175,R.raw.th2176,R.raw.th2177,R.raw.th2178,R.raw.th2179,R.raw.th2180
            ,R.raw.th2181,R.raw.th2182,R.raw.th2183,R.raw.th2184,R.raw.th2185,R.raw.th2186,R.raw.th2187,R.raw.th2188,R.raw.th2189,R.raw.th2190
            ,R.raw.th2191,R.raw.th2192,R.raw.th2193,R.raw.th2194,R.raw.th2195,R.raw.th2196,R.raw.th2197,R.raw.th2198,R.raw.th2199,R.raw.th2200
            ,R.raw.th2201,R.raw.th2202,R.raw.th2203,R.raw.th2204,R.raw.th2205,R.raw.th2206,R.raw.th2207,R.raw.th2208,R.raw.th2209,R.raw.th2210
            ,R.raw.th2211,R.raw.th2212,R.raw.th2213,R.raw.th2214,R.raw.th2215,R.raw.th2216,R.raw.th2217,R.raw.th2218,R.raw.th2219,R.raw.th2220
            ,R.raw.th2221,R.raw.th2222,R.raw.th2223,R.raw.th2224,R.raw.th2225,R.raw.th2226,R.raw.th2227,R.raw.th2228,R.raw.th2229,R.raw.th2230
            ,R.raw.th2231,R.raw.th2232,R.raw.th2233,R.raw.th2234,R.raw.th2235,R.raw.th2236,R.raw.th2237,R.raw.th2238,R.raw.th2239,R.raw.th2240
            ,R.raw.th2241,R.raw.th2242,R.raw.th2243,R.raw.th2244,R.raw.th2245,R.raw.th2246,R.raw.th2247,R.raw.th2248,R.raw.th2249,R.raw.th2250
            ,R.raw.th2251,R.raw.th2252,R.raw.th2253,R.raw.th2254,R.raw.th2255,R.raw.th2256,R.raw.th2257,R.raw.th2258,R.raw.th2259,R.raw.th2260
            ,R.raw.th2261,R.raw.th2262,R.raw.th2263,R.raw.th2264,R.raw.th2265,R.raw.th2266,R.raw.th2267,R.raw.th2268,R.raw.th2269,R.raw.th2270
            ,R.raw.th2271,R.raw.th2272,R.raw.th2273,R.raw.th2274,R.raw.th2275,R.raw.th2276,R.raw.th2277,R.raw.th2278,R.raw.th2279,R.raw.th2280
            ,R.raw.th2281,R.raw.th2282,R.raw.th2283,R.raw.th2284,R.raw.th2285,R.raw.th2286,R.raw.th2287,R.raw.th2288,R.raw.th2289,R.raw.th2290
            ,R.raw.th2291,R.raw.th2292,R.raw.th2293,R.raw.th2294,R.raw.th2295,R.raw.th2296,R.raw.th2297,R.raw.th2298,R.raw.th2299,R.raw.th2300
            ,R.raw.th2301,R.raw.th3202,R.raw.th2303,R.raw.th2304,R.raw.th2305,R.raw.th2306,R.raw.th2307,R.raw.th2308,R.raw.th2309,R.raw.th2310
            ,R.raw.th2311,R.raw.th2312,R.raw.th2313,R.raw.th2314,R.raw.th2315,R.raw.th2316,R.raw.th2317,R.raw.th2318,R.raw.th2319,R.raw.th2320
            ,R.raw.th2321,R.raw.th2322,R.raw.th2323,R.raw.th2324,R.raw.th2325,R.raw.th2326,R.raw.th2327,R.raw.th2328,R.raw.th2329,R.raw.th2330
            ,R.raw.th2331,R.raw.th2332,R.raw.th2333,R.raw.th2334,R.raw.th2335,R.raw.th2336,R.raw.th2337,R.raw.th2338,R.raw.th2339,R.raw.th2340
            ,R.raw.th2341,R.raw.th2342,R.raw.th2343,R.raw.th2344,R.raw.th2345,R.raw.th2346,R.raw.th2347,R.raw.th2348,R.raw.th2349,R.raw.th2350
            ,R.raw.th2351,R.raw.th2352,R.raw.th2353,R.raw.th2354,R.raw.th2355,R.raw.th2356,R.raw.th2357,R.raw.th2358,R.raw.th2359,R.raw.th2360
            ,R.raw.th2361,R.raw.th2362,R.raw.th2363,R.raw.th2364,R.raw.th2365,R.raw.th2366,R.raw.th2367,R.raw.th2368,R.raw.th2369,R.raw.th2370
            ,R.raw.th2371,R.raw.th2372,R.raw.th2373,R.raw.th2374,R.raw.th2375,R.raw.th2376,R.raw.th2377,R.raw.th2378,R.raw.th2379,R.raw.th2380
            ,R.raw.th2381,R.raw.th2382,R.raw.th2383,R.raw.th2384,R.raw.th2385,R.raw.th2386,R.raw.th2387,R.raw.th2388,R.raw.th2389,R.raw.th2390
            ,R.raw.th2391,R.raw.th2392,R.raw.th2393,R.raw.th2394,R.raw.th2395,R.raw.th2396,R.raw.th2397,R.raw.th2398,R.raw.th2399,R.raw.th2400
            ,R.raw.th2401,R.raw.th2402,R.raw.th2403,R.raw.th2404,R.raw.th2405,R.raw.th2406,R.raw.th2407,R.raw.th2408,R.raw.th2409,R.raw.th2410
            ,R.raw.th2411,R.raw.th2412,R.raw.th2413,R.raw.th2414,R.raw.th2415,R.raw.th2416,R.raw.th2417,R.raw.th2418,R.raw.th2419,R.raw.th2420
            ,R.raw.th2421,R.raw.th2422,R.raw.th2423,R.raw.th2424,R.raw.th2425,R.raw.th2426,R.raw.th2427,R.raw.th2428,R.raw.th2429,R.raw.th2430
            ,R.raw.th2431,R.raw.th2432,R.raw.th2433,R.raw.th2434,R.raw.th2435,R.raw.th2436,R.raw.th2437,R.raw.th2438,R.raw.th2439,R.raw.th2440
            ,R.raw.th2441,R.raw.th2442,R.raw.th2443,R.raw.th2444,R.raw.th2445,R.raw.th2446,R.raw.th2447,R.raw.th2448,R.raw.th2449,R.raw.th2450
            ,R.raw.th2451,R.raw.th2452,R.raw.th2453,R.raw.th2454,R.raw.th2455,R.raw.th2456,R.raw.th2457,R.raw.th2458,R.raw.th2459,R.raw.th2460
            ,R.raw.th2461,R.raw.th2462,R.raw.th2463,R.raw.th2464,R.raw.th2465,R.raw.th2466,R.raw.th2467,R.raw.th2468,R.raw.th2469,R.raw.th2470
            ,R.raw.th2471,R.raw.th2472,R.raw.th2473,R.raw.th2474,R.raw.th2475,R.raw.th2476,R.raw.th2477,R.raw.th2478,R.raw.th2479,R.raw.th2480
            ,R.raw.th2481,R.raw.th2482,R.raw.th2483,R.raw.th2484,R.raw.th2485,R.raw.th2486,R.raw.th2487,R.raw.th2488,R.raw.th2489,R.raw.th2490
            ,R.raw.th2491,R.raw.th2492,R.raw.th2493,R.raw.th2494,R.raw.th2495,R.raw.th2496,R.raw.th2497,R.raw.th2498,R.raw.th2499,R.raw.th2500
            ,R.raw.th2501,R.raw.th2502,R.raw.th2503,R.raw.th2504,R.raw.th2505,R.raw.th2506,R.raw.th2507,R.raw.th2508,R.raw.th2509,R.raw.th2510
            ,R.raw.th2511,R.raw.th2512,R.raw.th2513,R.raw.th2514,R.raw.th2515,R.raw.th2516,R.raw.th2517,R.raw.th2518,R.raw.th2519,R.raw.th2520
            ,R.raw.th2521,R.raw.th2522,R.raw.th2523,R.raw.th2524,R.raw.th2525,R.raw.th2526,R.raw.th2527,R.raw.th2528,R.raw.th2529,R.raw.th2530
            ,R.raw.th2531,R.raw.th2532,R.raw.th2533,R.raw.th2534,R.raw.th2535,R.raw.th2536,R.raw.th2537,R.raw.th2538,R.raw.th2539,R.raw.th2540
            ,R.raw.th2541,R.raw.th2542,R.raw.th2543,R.raw.th2544,R.raw.th2545,R.raw.th2546,R.raw.th2547,R.raw.th2548,R.raw.th2549,R.raw.th2550
            ,R.raw.th2551,R.raw.th2552,R.raw.th2553,R.raw.th2554,R.raw.th2555,R.raw.th2556,R.raw.th2557,R.raw.th2558,R.raw.th2559,R.raw.th2560
            ,R.raw.th2561,R.raw.th2562,R.raw.th2563,R.raw.th2564,R.raw.th2565,R.raw.th2566,R.raw.th2567,R.raw.th2568,R.raw.th2569,R.raw.th2570
            ,R.raw.th2571,R.raw.th2572,R.raw.th2573,R.raw.th2574,R.raw.th2575,R.raw.th2576,R.raw.th2577,R.raw.th2578,R.raw.th2579,R.raw.th2580
            ,R.raw.th2581,R.raw.th2582,R.raw.th2583,R.raw.th2584,R.raw.th2585,R.raw.th2586,R.raw.th2587,R.raw.th2588,R.raw.th2589,R.raw.th2590
            ,R.raw.th2591,R.raw.th2592,R.raw.th2593,R.raw.th2594,R.raw.th2595,R.raw.th2596,R.raw.th2597,R.raw.th2598,R.raw.th2599,R.raw.th2600
            ,R.raw.th2601,R.raw.th2602,R.raw.th2603,R.raw.th2604,R.raw.th2605,R.raw.th2606,R.raw.th2607,R.raw.th2608,R.raw.th2609,R.raw.th2610
            ,R.raw.th2611,R.raw.th2612,R.raw.th2613,R.raw.th2614,R.raw.th2615,R.raw.th2616,R.raw.th2617,R.raw.th2618,R.raw.th2619,R.raw.th2620
            ,R.raw.th2621,R.raw.th2622,R.raw.th2623,R.raw.th2624,R.raw.th2625,R.raw.th2626,R.raw.th2627,R.raw.th2628,R.raw.th2629,R.raw.th2630
            ,R.raw.th2631,R.raw.th2632,R.raw.th2633,R.raw.th2634,R.raw.th2635,R.raw.th2636,R.raw.th2637,R.raw.th2638,R.raw.th2639,R.raw.th2640
            ,R.raw.th2641,R.raw.th2642,R.raw.th2643,R.raw.th2644,R.raw.th2645,R.raw.th2646,R.raw.th2647,R.raw.th2648,R.raw.th2649,R.raw.th2650
            ,R.raw.th2651,R.raw.th2652,R.raw.th2653,R.raw.th2654,R.raw.th2655,R.raw.th2656,R.raw.th2657,R.raw.th2658,R.raw.th2659,R.raw.th2660
            ,R.raw.th2661,R.raw.th2662,R.raw.th2663,R.raw.th2664,R.raw.th2665,R.raw.th2666,R.raw.th2667,R.raw.th2668,R.raw.th2669,R.raw.th2670
            ,R.raw.th2671,R.raw.th2672,R.raw.th2673,R.raw.th2674,R.raw.th2675,R.raw.th2676,R.raw.th2677,R.raw.th2678,R.raw.th2679,R.raw.th2680
            ,R.raw.th2681,R.raw.th2682,R.raw.th2683,R.raw.th2684,R.raw.th2685,R.raw.th2686,R.raw.th2687,R.raw.th2688,R.raw.th2689,R.raw.th2690
            ,R.raw.th2691,R.raw.th2692,R.raw.th2693,R.raw.th2694,R.raw.th2695,R.raw.th2696,R.raw.th2697,R.raw.th2698,R.raw.th2699,R.raw.th2700
            ,R.raw.th2701,R.raw.th2702,R.raw.th2703,R.raw.th2704,R.raw.th2705,R.raw.th2706,R.raw.th2707,R.raw.th2708,R.raw.th2709,R.raw.th2710
            ,R.raw.th2711,R.raw.th2712,R.raw.th2713,R.raw.th2714,R.raw.th2715,R.raw.th2716,R.raw.th2717,R.raw.th2718,R.raw.th2719,R.raw.th2720
            ,R.raw.th2721,R.raw.th2722,R.raw.th2723,R.raw.th2724,R.raw.th2725,R.raw.th2726,R.raw.th2727,R.raw.th2728,R.raw.th2729,R.raw.th2730
            ,R.raw.th2731,R.raw.th2732,R.raw.th2733,R.raw.th2734,R.raw.th2735,R.raw.th2736,R.raw.th2737,R.raw.th2738,R.raw.th2739,R.raw.th2740
            ,R.raw.th2741,R.raw.th2742,R.raw.th2743,R.raw.th2744,R.raw.th2745,R.raw.th2746,R.raw.th2747,R.raw.th2748,R.raw.th2749,R.raw.th2750
            ,R.raw.th2751,R.raw.th2752,R.raw.th2753,R.raw.th2754,R.raw.th2755,R.raw.th2756,R.raw.th2757,R.raw.th2758,R.raw.th2759,R.raw.th2760
            ,R.raw.th2761,R.raw.th2762,R.raw.th2763,R.raw.th2764,R.raw.th2765,R.raw.th2766,R.raw.th2767,R.raw.th2768,R.raw.th2769,R.raw.th2770
            ,R.raw.th2771,R.raw.th2772,R.raw.th2773,R.raw.th2774,R.raw.th2775,R.raw.th2776,R.raw.th2777,R.raw.th2778,R.raw.th2779,R.raw.th2780
            ,R.raw.th2781,R.raw.th2782,R.raw.th2783,R.raw.th2784,R.raw.th2785,R.raw.th2786,R.raw.th2787,R.raw.th2788,R.raw.th2789,R.raw.th2790
            ,R.raw.th2791,R.raw.th2792,R.raw.th2793,R.raw.th2794,R.raw.th2795,R.raw.th2796,R.raw.th2797,R.raw.th2798,R.raw.th2799,R.raw.th2800
            ,R.raw.th2801,R.raw.th2802,R.raw.th2803,R.raw.th2804,R.raw.th2805,R.raw.th2806,R.raw.th2807,R.raw.th2808,R.raw.th2809,R.raw.th2810
            ,R.raw.th2811,R.raw.th2812,R.raw.th2813,R.raw.th2814,R.raw.th2815,R.raw.th2816,R.raw.th2817,R.raw.th2818,R.raw.th2819,R.raw.th2820
            ,R.raw.th2821,R.raw.th2822,R.raw.th2823,R.raw.th2824,R.raw.th2825,R.raw.th2826,R.raw.th2827,R.raw.th2828,R.raw.th2829,R.raw.th2830
            ,R.raw.th2831,R.raw.th2832,R.raw.th2833,R.raw.th2834,R.raw.th2835,R.raw.th2836,R.raw.th2837,R.raw.th2838,R.raw.th2839,R.raw.th2840
            ,R.raw.th2841,R.raw.th2842,R.raw.th2843,R.raw.th2844,R.raw.th2845,R.raw.th2846,R.raw.th2847,R.raw.th2848,R.raw.th2849,R.raw.th2850
            ,R.raw.th2851,R.raw.th2852,R.raw.th2853,R.raw.th2854,R.raw.th2855,R.raw.th2856,R.raw.th2857,R.raw.th2858,R.raw.th2859,R.raw.th2860
            ,R.raw.th2861,R.raw.th2862,R.raw.th2863,R.raw.th2864,R.raw.th2865,R.raw.th2866,R.raw.th2867,R.raw.th2868,R.raw.th2869,R.raw.th2870
            ,R.raw.th2871,R.raw.th2872,R.raw.th2873,R.raw.th2874,R.raw.th2875,R.raw.th2876,R.raw.th2877,R.raw.th2878,R.raw.th2879,R.raw.th2880
            ,R.raw.th2881,R.raw.th2882,R.raw.th2883,R.raw.th2884,R.raw.th2885,R.raw.th2886,R.raw.th2887,R.raw.th2888,R.raw.th2889,R.raw.th2890
            ,R.raw.th2891,R.raw.th2892,R.raw.th2893,R.raw.th2894,R.raw.th2895,R.raw.th2896,R.raw.th2897,R.raw.th2898,R.raw.th2899,R.raw.th2900
            ,R.raw.th2901,R.raw.th2902,R.raw.th2903,R.raw.th2904,R.raw.th2905,R.raw.th2906,R.raw.th2907,R.raw.th2908,R.raw.th2909,R.raw.th2910
            ,R.raw.th2911,R.raw.th2912,R.raw.th2913,R.raw.th2914,R.raw.th2915,R.raw.th2916,R.raw.th2917,R.raw.th2918,R.raw.th2919,R.raw.th2920
            ,R.raw.th2921,R.raw.th2922,R.raw.th2923,R.raw.th2924,R.raw.th2925,R.raw.th2926,R.raw.th2927,R.raw.th2928,R.raw.th2929,R.raw.th2930
            ,R.raw.th2931,R.raw.th2932,R.raw.th2933,R.raw.th2934,R.raw.th2935,R.raw.th2936,R.raw.th2937,R.raw.th2938,R.raw.th2939,R.raw.th2940
            ,R.raw.th2941,R.raw.th2942,R.raw.th2943,R.raw.th2944,R.raw.th2945,R.raw.th2946,R.raw.th2947,R.raw.th2948,R.raw.th2949,R.raw.th2950
            ,R.raw.th2951,R.raw.th2952,R.raw.th2953,R.raw.th2954,R.raw.th2955,R.raw.th2956,R.raw.th2957,R.raw.th2958,R.raw.th2959,R.raw.th2960
            ,R.raw.th2961,R.raw.th2962,R.raw.th2963,R.raw.th2964,R.raw.th2965,R.raw.th2966,R.raw.th2967,R.raw.th2968,R.raw.th2969,R.raw.th2970
            ,R.raw.th2971,R.raw.th2972,R.raw.th2973,R.raw.th2974,R.raw.th2975,R.raw.th2976,R.raw.th2977,R.raw.th2978,R.raw.th2979,R.raw.th2980
            ,R.raw.th2981,R.raw.th2982,R.raw.th2983,R.raw.th2984,R.raw.th2985,R.raw.th2986,R.raw.th2987,R.raw.th2988,R.raw.th2989,R.raw.th2990
            ,R.raw.th2991,R.raw.th2992,R.raw.th2993,R.raw.th2994,R.raw.th2995,R.raw.th2996,R.raw.th2997,R.raw.th2998,R.raw.th2999,R.raw.th3000
            ,R.raw.th3001,R.raw.th3002,R.raw.th3003,R.raw.th3004,R.raw.th3005,R.raw.th3006,R.raw.th3007,R.raw.th3008,R.raw.th3009,R.raw.th3010
            ,R.raw.th3011,R.raw.th3012,R.raw.th3013,R.raw.th3014,R.raw.th3015,R.raw.th3016,R.raw.th3017,R.raw.th3018,R.raw.th3019,R.raw.th3020
            ,R.raw.th3021,R.raw.th3022,R.raw.th3023,R.raw.th3024,R.raw.th3025,R.raw.th3026,R.raw.th3027,R.raw.th3028,R.raw.th3029,R.raw.th3030
            ,R.raw.th3031,R.raw.th3032,R.raw.th3033,R.raw.th3034,R.raw.th3035,R.raw.th3036,R.raw.th3037,R.raw.th3038,R.raw.th3039,R.raw.th3040
            ,R.raw.th3041,R.raw.th3042,R.raw.th3043,R.raw.th3044,R.raw.th3045,R.raw.th3046,R.raw.th3047,R.raw.th3048,R.raw.th3049,R.raw.th3050
            ,R.raw.th3051,R.raw.th3052,R.raw.th3053,R.raw.th3054,R.raw.th3055,R.raw.th3056,R.raw.th3057,R.raw.th3058,R.raw.th3059,R.raw.th3060
            ,R.raw.th3061,R.raw.th3062,R.raw.th3063,R.raw.th3064,R.raw.th3065,R.raw.th3066,R.raw.th3067,R.raw.th3068,R.raw.th3069,R.raw.th3070
            ,R.raw.th3071,R.raw.th3072,R.raw.th3073,R.raw.th3074,R.raw.th3075,R.raw.th3076,R.raw.th3077,R.raw.th3078,R.raw.th3079,R.raw.th3080
            ,R.raw.th3081,R.raw.th3082,R.raw.th3083,R.raw.th3084,R.raw.th3085,R.raw.th3086,R.raw.th3087,R.raw.th3088,R.raw.th3089,R.raw.th3090
            ,R.raw.th3091,R.raw.th3092,R.raw.th3093,R.raw.th3094,R.raw.th3095,R.raw.th3096,R.raw.th3097,R.raw.th3098,R.raw.th3099,R.raw.th3100
            ,R.raw.th3101,R.raw.th3102,R.raw.th3103,R.raw.th3104,R.raw.th3105,R.raw.th3106,R.raw.th3107,R.raw.th3108,R.raw.th3109,R.raw.th3110
            ,R.raw.th3111,R.raw.th3112,R.raw.th3113,R.raw.th3114,R.raw.th3115,R.raw.th3116,R.raw.th3117,R.raw.th3118,R.raw.th3119,R.raw.th3120
            ,R.raw.th3121,R.raw.th3122,R.raw.th3123,R.raw.th3124,R.raw.th3125,R.raw.th3126,R.raw.th3127,R.raw.th3128,R.raw.th3129,R.raw.th3130
            ,R.raw.th3131,R.raw.th3132,R.raw.th3133,R.raw.th3134,R.raw.th3135,R.raw.th3136,R.raw.th3137,R.raw.th3138,R.raw.th3139,R.raw.th3140
            ,R.raw.th3141,R.raw.th3142,R.raw.th3143,R.raw.th3144,R.raw.th3145,R.raw.th3146,R.raw.th3147,R.raw.th3148,R.raw.th3149,R.raw.th3150
            ,R.raw.th3151,R.raw.th3152,R.raw.th3153,R.raw.th3154,R.raw.th3155,R.raw.th3156,R.raw.th3157,R.raw.th3158,R.raw.th3159,R.raw.th3160
            ,R.raw.th3161,R.raw.th3162,R.raw.th3163,R.raw.th3164,R.raw.th3165,R.raw.th3166,R.raw.th3167,R.raw.th3168,R.raw.th3169,R.raw.th3170
            ,R.raw.th3171,R.raw.th3172,R.raw.th3173,R.raw.th3174,R.raw.th3175,R.raw.th3176,R.raw.th3177,R.raw.th3178,R.raw.th3179,R.raw.th3180
            ,R.raw.th3181,R.raw.th3182,R.raw.th3183,R.raw.th3184,R.raw.th3185,R.raw.th3186,R.raw.th3187,R.raw.th3188,R.raw.th3189,R.raw.th3190
            ,R.raw.th3191,R.raw.th3192,R.raw.th3193,R.raw.th3194,R.raw.th3195,R.raw.th3196,R.raw.th3197,R.raw.th3198,R.raw.th3199,R.raw.th3200
            ,R.raw.th3201,R.raw.th3202,R.raw.th3203,R.raw.th3204,R.raw.th3205,R.raw.th3206,R.raw.th3207,R.raw.th3208,R.raw.th3209,R.raw.th3210
            ,R.raw.th3211,R.raw.th3212,R.raw.th3213,R.raw.th3214,R.raw.th3215,R.raw.th3216,R.raw.th3217,R.raw.th3218,R.raw.th3219,R.raw.th3220
            ,R.raw.th3221,R.raw.th3222,R.raw.th3223,R.raw.th3224,R.raw.th3225,R.raw.th3226,R.raw.th3227,R.raw.th3228,R.raw.th3229,R.raw.th3230
            ,R.raw.th3231,R.raw.th3232,R.raw.th3233,R.raw.th3234,R.raw.th3235,R.raw.th3236,R.raw.th3237,R.raw.th3238,R.raw.th3239,R.raw.th3240
            ,R.raw.th3241,R.raw.th3242,R.raw.th3243,R.raw.th3244,R.raw.th3245,R.raw.th3246,R.raw.th3247,R.raw.th3248,R.raw.th3249,R.raw.th3250
            ,R.raw.th3251,R.raw.th3252,R.raw.th3253,R.raw.th3254,R.raw.th3255,R.raw.th3256,R.raw.th3257,R.raw.th3258,R.raw.th3259,R.raw.th3260
            ,R.raw.th3261,R.raw.th3262,R.raw.th3263,R.raw.th3264,R.raw.th3265,R.raw.th3266,R.raw.th3267,R.raw.th3268,R.raw.th3269,R.raw.th3270
            ,R.raw.th3271,R.raw.th3272,R.raw.th3273,R.raw.th3274,R.raw.th3275,R.raw.th3276,R.raw.th3277,R.raw.th3278,R.raw.th3279,R.raw.th3280
            ,R.raw.th3281,R.raw.th3282,R.raw.th3283,R.raw.th3284,R.raw.th3285,R.raw.th3286,R.raw.th3287,R.raw.th3288,R.raw.th3289,R.raw.th3290
            ,R.raw.th3291,R.raw.th3292,R.raw.th3293,R.raw.th3294,R.raw.th3295,R.raw.th3296,R.raw.th3297,R.raw.th3298,R.raw.th3299,R.raw.th3300
            ,R.raw.th3301,R.raw.th3302,R.raw.th3303,R.raw.th3304,R.raw.th3305,R.raw.th3306,R.raw.th3307,R.raw.th3308,R.raw.th3309,R.raw.th3310
            ,R.raw.th3311,R.raw.th3312,R.raw.th3313,R.raw.th3314,R.raw.th3315,R.raw.th3316,R.raw.th3317,R.raw.th3318,R.raw.th3319,R.raw.th3320
            ,R.raw.th3321,R.raw.th3322,R.raw.th3323,R.raw.th3324,R.raw.th3325,R.raw.th3326,R.raw.th3327,R.raw.th3328,R.raw.th3329,R.raw.th3330
            ,R.raw.th3331,R.raw.th3332,R.raw.th3333,R.raw.th3334,R.raw.th3335,R.raw.th3336,R.raw.th3337,R.raw.th3338,R.raw.th3339,R.raw.th3340
            ,R.raw.th3341,R.raw.th3342,R.raw.th3343,R.raw.th3344,R.raw.th3345,R.raw.th3346,R.raw.th3347,R.raw.th3348,R.raw.th3349,R.raw.th3350
            ,R.raw.th3351,R.raw.th3352,R.raw.th3353,R.raw.th3354,R.raw.th3355,R.raw.th3356,R.raw.th3357,R.raw.th3358,R.raw.th3359,R.raw.th3360
            ,R.raw.th3361,R.raw.th3362,R.raw.th3363,R.raw.th3364,R.raw.th3365,R.raw.th3366,R.raw.th3367,R.raw.th3368,R.raw.th3369,R.raw.th3370
            ,R.raw.th3371,R.raw.th3372,R.raw.th3373,R.raw.th3374,R.raw.th3375,R.raw.th3376,R.raw.th3377,R.raw.th3378,R.raw.th3379,R.raw.th3380
            ,R.raw.th3381,R.raw.th3382,R.raw.th3383,R.raw.th3384,R.raw.th3385,R.raw.th3386,R.raw.th3387,R.raw.th3388,R.raw.th3389,R.raw.th3390
            ,R.raw.th3391,R.raw.th3392,R.raw.th3393,R.raw.th3394,R.raw.th3395,R.raw.th3396,R.raw.th3397,R.raw.th3398,R.raw.th3399,R.raw.th3400
            ,R.raw.th3401,R.raw.th3402,R.raw.th3403,R.raw.th3404,R.raw.th3405,R.raw.th3406,R.raw.th3407,R.raw.th3408,R.raw.th3409,R.raw.th3410
            ,R.raw.th3411,R.raw.th3412,R.raw.th3413,R.raw.th3414,R.raw.th3415,R.raw.th3416,R.raw.th3417,R.raw.th3418,R.raw.th3419,R.raw.th3420
            ,R.raw.th3421,R.raw.th3422,R.raw.th3423,R.raw.th3424,R.raw.th3425,R.raw.th3426,R.raw.th3427,R.raw.th3428,R.raw.th3429,R.raw.th3430
            ,R.raw.th3431,R.raw.th3432,R.raw.th3433,R.raw.th3434,R.raw.th3435,R.raw.th3436,R.raw.th3437,R.raw.th3438,R.raw.th3439,R.raw.th3440
            ,R.raw.th3441,R.raw.th3442,R.raw.th3443,R.raw.th3444,R.raw.th3445,R.raw.th3446,R.raw.th3447,R.raw.th3448,R.raw.th3449,R.raw.th3450
            ,R.raw.th3451,R.raw.th3452,R.raw.th3453,R.raw.th3454,R.raw.th3455,R.raw.th3456,R.raw.th3457,R.raw.th3458,R.raw.th3459,R.raw.th3460
            ,R.raw.th3461,R.raw.th3462,R.raw.th3463,R.raw.th3464,R.raw.th3465,R.raw.th3466,R.raw.th3467,R.raw.th3468,R.raw.th3469,R.raw.th3470
            ,R.raw.th3471,R.raw.th3472,R.raw.th3473,R.raw.th3474,R.raw.th3475,R.raw.th3476,R.raw.th3477,R.raw.th3478,R.raw.th3479,R.raw.th3480
            ,R.raw.th3481,R.raw.th3482,R.raw.th3483,R.raw.th3484,R.raw.th3485,R.raw.th3486,R.raw.th3487,R.raw.th3488,R.raw.th3489,R.raw.th3490
            ,R.raw.th3491,R.raw.th3492,R.raw.th3493,R.raw.th3494,R.raw.th3495,R.raw.th3496,R.raw.th3497,R.raw.th3498,R.raw.th3499,R.raw.th3500
            ,R.raw.th3501,R.raw.th3502,R.raw.th3503,R.raw.th3504,R.raw.th3505,R.raw.th3506,R.raw.th3507,R.raw.th3508,R.raw.th3509,R.raw.th3510
            ,R.raw.th3511,R.raw.th3512,R.raw.th3513,R.raw.th3514,R.raw.th3515,R.raw.th3516,R.raw.th3517,R.raw.th3518,R.raw.th3519,R.raw.th3520
            ,R.raw.th3521,R.raw.th3522,R.raw.th3523,R.raw.th3524,R.raw.th3525,R.raw.th3526,R.raw.th3527,R.raw.th3528,R.raw.th3529,R.raw.th3530
            ,R.raw.th3531,R.raw.th3532,R.raw.th3533,R.raw.th3534,R.raw.th3535,R.raw.th3536,R.raw.th3537,R.raw.th3538,R.raw.th3539,R.raw.th3540
            ,R.raw.th3541,R.raw.th3542,R.raw.th3543,R.raw.th3544,R.raw.th3545,R.raw.th3546,R.raw.th3547,R.raw.th3548,R.raw.th3549,R.raw.th3550
            ,R.raw.th3551,R.raw.th3552,R.raw.th3553,R.raw.th3554,R.raw.th3555,R.raw.th3556,R.raw.th3557,R.raw.th3558,R.raw.th3559,R.raw.th3560
            ,R.raw.th3561,R.raw.th3562,R.raw.th3563,R.raw.th3564,R.raw.th3565,R.raw.th3566,R.raw.th3567,R.raw.th3568,R.raw.th3569,R.raw.th3570
            ,R.raw.th3571,R.raw.th3572,R.raw.th3573,R.raw.th3574,R.raw.th3575,R.raw.th3576,R.raw.th3577,R.raw.th3578,R.raw.th3579,R.raw.th3580
            ,R.raw.th3581,R.raw.th3582,R.raw.th3583,R.raw.th3584,R.raw.th3585,R.raw.th3586,R.raw.th3587,R.raw.th3588,R.raw.th3589,R.raw.th3590
            ,R.raw.th3591,R.raw.th3592,R.raw.th3593,R.raw.th3594,R.raw.th3595,R.raw.th3596,R.raw.th3597,R.raw.th3598,R.raw.th3599,R.raw.th3600
            ,R.raw.th3601,R.raw.th3602,R.raw.th3603,R.raw.th3604,R.raw.th3605,R.raw.th3606,R.raw.th3607,R.raw.th3608,R.raw.th3609,R.raw.th3610
            ,R.raw.th3611,R.raw.th3612,R.raw.th3613,R.raw.th3614,R.raw.th3615,R.raw.th3616,R.raw.th3617,R.raw.th3618,R.raw.th3619,R.raw.th3620
            ,R.raw.th3621,R.raw.th3622,R.raw.th3623,R.raw.th3624,R.raw.th3625,R.raw.th3626,R.raw.th3627,R.raw.th3628,R.raw.th3629,R.raw.th3630
            ,R.raw.th3631,R.raw.th3632,R.raw.th3633,R.raw.th3634,R.raw.th3635,R.raw.th3636,R.raw.th3637,R.raw.th3638,R.raw.th3639,R.raw.th3640
            ,R.raw.th3641,R.raw.th3642,R.raw.th3643,R.raw.th3644,R.raw.th3645,R.raw.th3646,R.raw.th3647,R.raw.th3648,R.raw.th3649,R.raw.th3650
            ,R.raw.th3651,R.raw.th3652,R.raw.th3653,R.raw.th3654,R.raw.th3655,R.raw.th3656,R.raw.th3657,R.raw.th3658,R.raw.th3659,R.raw.th3660
            ,R.raw.th3661,R.raw.th3662,R.raw.th3663,R.raw.th3664,R.raw.th3665,R.raw.th3666,R.raw.th3667,R.raw.th3668,R.raw.th3669,R.raw.th3670
            ,R.raw.th3671,R.raw.th3672,R.raw.th3673,R.raw.th3674,R.raw.th3675,R.raw.th3676,R.raw.th3677,R.raw.th3678,R.raw.th3679,R.raw.th3680
            ,R.raw.th3681,R.raw.th3682,R.raw.th3683,R.raw.th3684,R.raw.th3685,R.raw.th3686,R.raw.th3687,R.raw.th3688,R.raw.th3689,R.raw.th3690
            ,R.raw.th3691,R.raw.th3692,R.raw.th3693,R.raw.th3694,R.raw.th3695,R.raw.th3696,R.raw.th3697,R.raw.th3698,R.raw.th3699,R.raw.th3700
            ,R.raw.th3701,R.raw.th3702,R.raw.th3703,R.raw.th3704,R.raw.th3705,R.raw.th3706,R.raw.th3707,R.raw.th3708,R.raw.th3709,R.raw.th3710
            ,R.raw.th3711,R.raw.th3712,R.raw.th3713,R.raw.th3714,R.raw.th3715,R.raw.th3716,R.raw.th3717,R.raw.th3718,R.raw.th3719,R.raw.th3720
            ,R.raw.th3721,R.raw.th3722,R.raw.th3723,R.raw.th3724,R.raw.th3725,R.raw.th3726,R.raw.th3727,R.raw.th3728,R.raw.th3729,R.raw.th3730
            ,R.raw.th3731,R.raw.th3732,R.raw.th3733,R.raw.th3734,R.raw.th3735,R.raw.th3736,R.raw.th3737,R.raw.th3738,R.raw.th3739,R.raw.th3740
            ,R.raw.th3741,R.raw.th3742,R.raw.th3743,R.raw.th3744,R.raw.th3745,R.raw.th3746,R.raw.th3747,R.raw.th3748,R.raw.th3749,R.raw.th3750
            ,R.raw.th3751,R.raw.th3752,R.raw.th3753,R.raw.th3754,R.raw.th3755,R.raw.th3756,R.raw.th3757,R.raw.th3758,R.raw.th3759,R.raw.th3760
            ,R.raw.th3761,R.raw.th3762,R.raw.th3763,R.raw.th3764,R.raw.th3765,R.raw.th3766,R.raw.th3767,R.raw.th3768,R.raw.th3769,R.raw.th3770
            ,R.raw.th3771,R.raw.th3772,R.raw.th3773,R.raw.th3774,R.raw.th3775,R.raw.th3776,R.raw.th3777,R.raw.th3778,R.raw.th3779,R.raw.th3780
            ,R.raw.th3781,R.raw.th3782,R.raw.th3783,R.raw.th3784,R.raw.th3785,R.raw.th3786,R.raw.th3787,R.raw.th3788,R.raw.th3789,R.raw.th3790
            ,R.raw.th3791,R.raw.th3792,R.raw.th3793,R.raw.th3794,R.raw.th3795,R.raw.th3796,R.raw.th3797,R.raw.th3798,R.raw.th3799,R.raw.th3800
            ,R.raw.th3801,R.raw.th3802,R.raw.th3803,R.raw.th3804,R.raw.th3805,R.raw.th3806,R.raw.th3807,R.raw.th3808,R.raw.th3809,R.raw.th3810
            ,R.raw.th3811,R.raw.th3812,R.raw.th3813,R.raw.th3814,R.raw.th3815,R.raw.th3816,R.raw.th3817,R.raw.th3818,R.raw.th3819,R.raw.th3820
            ,R.raw.th3821,R.raw.th3822,R.raw.th3823,R.raw.th3824,R.raw.th3825,R.raw.th3826,R.raw.th3827,R.raw.th3828,R.raw.th3829,R.raw.th3830
            ,R.raw.th3831,R.raw.th3832,R.raw.th3833,R.raw.th3834,R.raw.th3835,R.raw.th3836,R.raw.th3837,R.raw.th3838,R.raw.th3839,R.raw.th3840
            ,R.raw.th3841,R.raw.th3842,R.raw.th3843,R.raw.th3844,R.raw.th3845,R.raw.th3846,R.raw.th3847,R.raw.th3848,R.raw.th3849,R.raw.th3850
            ,R.raw.th3851,R.raw.th3852,R.raw.th3853,R.raw.th3854,R.raw.th3855,R.raw.th3856,R.raw.th3857,R.raw.th3858,R.raw.th3859,R.raw.th3860
            ,R.raw.th3861,R.raw.th3862,R.raw.th3863,R.raw.th3864,R.raw.th3865,R.raw.th3866,R.raw.th3867,R.raw.th3868,R.raw.th3869,R.raw.th3870
            ,R.raw.th3871,R.raw.th3872,R.raw.th3873,R.raw.th3874,R.raw.th3875,R.raw.th3876,R.raw.th3877,R.raw.th3878,R.raw.th3879,R.raw.th3880
            ,R.raw.th3881,R.raw.th3882,R.raw.th3883,R.raw.th3884,R.raw.th3885,R.raw.th3886,R.raw.th3887,R.raw.th3888,R.raw.th3889,R.raw.th3890
            ,R.raw.th3891,R.raw.th3892,R.raw.th3893,R.raw.th3894,R.raw.th3895,R.raw.th3896,R.raw.th3897,R.raw.th3898,R.raw.th3899,R.raw.th3900
            ,R.raw.th3901,R.raw.th3902,R.raw.th3903,R.raw.th3904,R.raw.th3905,R.raw.th3906,R.raw.th3907,R.raw.th3908,R.raw.th3909,R.raw.th3910
            ,R.raw.th3911,R.raw.th3912,R.raw.th3913,R.raw.th3914,R.raw.th3915,R.raw.th3916,R.raw.th3917,R.raw.th3918,R.raw.th3919,R.raw.th3920
            ,R.raw.th3921,R.raw.th3922,R.raw.th3923,R.raw.th3924,R.raw.th3925,R.raw.th3926,R.raw.th3927,R.raw.th3928,R.raw.th3929,R.raw.th3930
            ,R.raw.th3931,R.raw.th3932,R.raw.th3933,R.raw.th3934,R.raw.th3935,R.raw.th3936,R.raw.th3937,R.raw.th3938,R.raw.th3939,R.raw.th3940
            ,R.raw.th3941,R.raw.th3942,R.raw.th3943,R.raw.th3944,R.raw.th3945,R.raw.th3946,R.raw.th3947,R.raw.th3948,R.raw.th3949,R.raw.th3950
            ,R.raw.th3951,R.raw.th3952,R.raw.th3953,R.raw.th3954,R.raw.th3955,R.raw.th3956,R.raw.th3957,R.raw.th3958,R.raw.th3959,R.raw.th3960
            ,R.raw.th3961,R.raw.th3962,R.raw.th3963,R.raw.th3964,R.raw.th3965,R.raw.th3966,R.raw.th3967,R.raw.th3968,R.raw.th3969,R.raw.th3970
            ,R.raw.th3971,R.raw.th3972,R.raw.th3973,R.raw.th3974,R.raw.th3975,R.raw.th3976,R.raw.th3977,R.raw.th3978,R.raw.th3979,R.raw.th3980
            ,R.raw.th3981,R.raw.th3982,R.raw.th3983,R.raw.th3984,R.raw.th3985,R.raw.th3986,R.raw.th3987,R.raw.th3988,R.raw.th3989,R.raw.th3990
            ,R.raw.th3991,R.raw.th3992,R.raw.th3993,R.raw.th3994,R.raw.th3995,R.raw.th3996,R.raw.th3997,R.raw.th3998,R.raw.th3999,R.raw.th4000
            ,R.raw.th4001,R.raw.th4002,R.raw.th4003,R.raw.th4004,R.raw.th4005,R.raw.th4006,R.raw.th4007,R.raw.th4008,R.raw.th4009,R.raw.th4010
            ,R.raw.th4011,R.raw.th4012,R.raw.th4013,R.raw.th4014,R.raw.th4015,R.raw.th4016,R.raw.th4017,R.raw.th4018,R.raw.th4019,R.raw.th4020
            ,R.raw.th4021,R.raw.th4022,R.raw.th4023,R.raw.th4024,R.raw.th4025,R.raw.th4026,R.raw.th4027,R.raw.th4028,R.raw.th4029,R.raw.th4030
            ,R.raw.th4031,R.raw.th4032,R.raw.th4033,R.raw.th4034,R.raw.th4035,R.raw.th4036,R.raw.th4037,R.raw.th4038,R.raw.th4039,R.raw.th4040
            ,R.raw.th4041,R.raw.th4042,R.raw.th4043,R.raw.th4044,R.raw.th4045,R.raw.th4046,R.raw.th4047,R.raw.th4048,R.raw.th4049,R.raw.th4050
            ,R.raw.th4051,R.raw.th4052,R.raw.th4053,R.raw.th4054,R.raw.th4055,R.raw.th4056,R.raw.th4057,R.raw.th4058,R.raw.th4059,R.raw.th4060
            ,R.raw.th4061,R.raw.th4062,R.raw.th4063,R.raw.th4064,R.raw.th4065,R.raw.th4066,R.raw.th4067,R.raw.th4068,R.raw.th4069,R.raw.th4070
            ,R.raw.th4071,R.raw.th4072,R.raw.th4073,R.raw.th4074,R.raw.th4075,R.raw.th4076,R.raw.th4077,R.raw.th4078,R.raw.th4079,R.raw.th4080
            ,R.raw.th4081,R.raw.th4082,R.raw.th4083,R.raw.th4084,R.raw.th4085,R.raw.th4086,R.raw.th4087,R.raw.th4088,R.raw.th4089,R.raw.th4090
            ,R.raw.th4091,R.raw.th4092,R.raw.th4093,R.raw.th4094,R.raw.th4095,R.raw.th4096,R.raw.th4097,R.raw.th4098,R.raw.th4099,R.raw.th4100
            ,R.raw.th4101,R.raw.th4102};





    private int soundfileEN[]= new int[] {R.raw.en1,R.raw.en1,R.raw.en2,R.raw.en3,R.raw.en4,R.raw.en5,R.raw.en6,R.raw.en7,R.raw.en8,R.raw.en9,R.raw.en10
            ,R.raw.en11,R.raw.en12,R.raw.en13,R.raw.en14,R.raw.en15,R.raw.en16,R.raw.en17,R.raw.en18,R.raw.en19,R.raw.en20
            ,R.raw.en21,R.raw.en22,R.raw.en23,R.raw.en24,R.raw.en25,R.raw.en26,R.raw.en27,R.raw.en28,R.raw.en29,R.raw.en30
            ,R.raw.en31,R.raw.en32,R.raw.en33,R.raw.en34,R.raw.en35,R.raw.en36,R.raw.en37,R.raw.en38,R.raw.en39,R.raw.en40
            ,R.raw.en41,R.raw.en42,R.raw.en43,R.raw.en44,R.raw.en45,R.raw.en46,R.raw.en47,R.raw.en48,R.raw.en49,R.raw.en50
            ,R.raw.en51,R.raw.en52,R.raw.en53,R.raw.en54,R.raw.en55,R.raw.en56,R.raw.en57,R.raw.en58,R.raw.en59,R.raw.en60
            ,R.raw.en61,R.raw.en62,R.raw.en63,R.raw.en64,R.raw.en65,R.raw.en66,R.raw.en67,R.raw.en68,R.raw.en69,R.raw.en70
            ,R.raw.en71,R.raw.en72,R.raw.en73,R.raw.en74,R.raw.en75,R.raw.en76,R.raw.en77,R.raw.en78,R.raw.en79,R.raw.en80
            ,R.raw.en81,R.raw.en82,R.raw.en83,R.raw.en84,R.raw.en85,R.raw.en86,R.raw.en87,R.raw.en88,R.raw.en89,R.raw.en90
            ,R.raw.en91,R.raw.en92,R.raw.en93,R.raw.en94,R.raw.en95,R.raw.en96,R.raw.en97,R.raw.en98,R.raw.en99,R.raw.en100
            ,R.raw.en101,R.raw.en102,R.raw.en103,R.raw.en104,R.raw.en105,R.raw.en106,R.raw.en107,R.raw.en108,R.raw.en109,R.raw.en110
            ,R.raw.en111,R.raw.en112,R.raw.en113,R.raw.en114,R.raw.en115,R.raw.en116,R.raw.en117,R.raw.en118,R.raw.en119,R.raw.en120
            ,R.raw.en121,R.raw.en122,R.raw.en123,R.raw.en124,R.raw.en125,R.raw.en126,R.raw.en127,R.raw.en128,R.raw.en129,R.raw.en130
            ,R.raw.en131,R.raw.en132,R.raw.en133,R.raw.en134,R.raw.en135,R.raw.en136,R.raw.en137,R.raw.en138,R.raw.en139,R.raw.en140
            ,R.raw.en141,R.raw.en142,R.raw.en143,R.raw.en144,R.raw.en145,R.raw.en146,R.raw.en147,R.raw.en148,R.raw.en149,R.raw.en150
            ,R.raw.en151,R.raw.en152,R.raw.en153,R.raw.en154,R.raw.en155,R.raw.en156,R.raw.en157,R.raw.en158,R.raw.en159,R.raw.en160
            ,R.raw.en161,R.raw.en162,R.raw.en163,R.raw.en164,R.raw.en165,R.raw.en166,R.raw.en167,R.raw.en168,R.raw.en169,R.raw.en170
            ,R.raw.en171,R.raw.en172,R.raw.en173,R.raw.en174,R.raw.en175,R.raw.en176,R.raw.en177,R.raw.en178,R.raw.en179,R.raw.en180
            ,R.raw.en181,R.raw.en182,R.raw.en183,R.raw.en184,R.raw.en185,R.raw.en186,R.raw.en187,R.raw.en188,R.raw.en189,R.raw.en190
            ,R.raw.en191,R.raw.en192,R.raw.en193,R.raw.en194,R.raw.en195,R.raw.en196,R.raw.en197,R.raw.en198,R.raw.en199,R.raw.en200
            ,R.raw.en201,R.raw.en202,R.raw.en203,R.raw.en204,R.raw.en205,R.raw.en206,R.raw.en207,R.raw.en208,R.raw.en209,R.raw.en210
            ,R.raw.en211,R.raw.en212,R.raw.en213,R.raw.en214,R.raw.en215,R.raw.en216,R.raw.en217,R.raw.en218,R.raw.en219,R.raw.en220
            ,R.raw.en221,R.raw.en222,R.raw.en223,R.raw.en224,R.raw.en225,R.raw.en226,R.raw.en227,R.raw.en228,R.raw.en229,R.raw.en230
            ,R.raw.en231,R.raw.en232,R.raw.en233,R.raw.en234,R.raw.en235,R.raw.en236,R.raw.en237,R.raw.en238,R.raw.en239,R.raw.en240
            ,R.raw.en241,R.raw.en242,R.raw.en243,R.raw.en244,R.raw.en245,R.raw.en246,R.raw.en247,R.raw.en248,R.raw.en249,R.raw.en250
            ,R.raw.en251,R.raw.en252,R.raw.en253,R.raw.en254,R.raw.en255,R.raw.en256,R.raw.en257,R.raw.en258,R.raw.en259,R.raw.en260
            ,R.raw.en261,R.raw.en262,R.raw.en263,R.raw.en264,R.raw.en265,R.raw.en266,R.raw.en267,R.raw.en268,R.raw.en269,R.raw.en270
            ,R.raw.en271,R.raw.en272,R.raw.en273,R.raw.en274,R.raw.en275,R.raw.en276,R.raw.en277,R.raw.en278,R.raw.en279,R.raw.en280
            ,R.raw.en281,R.raw.en282,R.raw.en283,R.raw.en284,R.raw.en285,R.raw.en286,R.raw.en287,R.raw.en288,R.raw.en289,R.raw.en290
            ,R.raw.en291,R.raw.en292,R.raw.en293,R.raw.en294,R.raw.en295,R.raw.en296,R.raw.en297,R.raw.en298,R.raw.en299,R.raw.en300
            ,R.raw.en301,R.raw.en302,R.raw.en303,R.raw.en304,R.raw.en305,R.raw.en306,R.raw.en307,R.raw.en308,R.raw.en309,R.raw.en310
            ,R.raw.en311,R.raw.en312,R.raw.en313,R.raw.en314,R.raw.en315,R.raw.en316,R.raw.en317,R.raw.en318,R.raw.en319,R.raw.en320
            ,R.raw.en321,R.raw.en322,R.raw.en323,R.raw.en324,R.raw.en325,R.raw.en326,R.raw.en327,R.raw.en328,R.raw.en329,R.raw.en330
            ,R.raw.en331,R.raw.en332,R.raw.en333,R.raw.en334,R.raw.en335,R.raw.en336,R.raw.en337,R.raw.en338,R.raw.en339,R.raw.en340
            ,R.raw.en341,R.raw.en342,R.raw.en343,R.raw.en344,R.raw.en345,R.raw.en346,R.raw.en347,R.raw.en348,R.raw.en349,R.raw.en350
            ,R.raw.en351,R.raw.en352,R.raw.en353,R.raw.en354,R.raw.en355,R.raw.en356,R.raw.en357,R.raw.en358,R.raw.en359,R.raw.en360
            ,R.raw.en361,R.raw.en362,R.raw.en363,R.raw.en364,R.raw.en365,R.raw.en366,R.raw.en367,R.raw.en368,R.raw.en369,R.raw.en370
            ,R.raw.en371,R.raw.en372,R.raw.en373,R.raw.en374,R.raw.en375,R.raw.en376,R.raw.en377,R.raw.en378,R.raw.en379,R.raw.en380
            ,R.raw.en381,R.raw.en382,R.raw.en383,R.raw.en384,R.raw.en385,R.raw.en386,R.raw.en387,R.raw.en388,R.raw.en389,R.raw.en390
            ,R.raw.en391,R.raw.en392,R.raw.en393,R.raw.en394,R.raw.en395,R.raw.en396,R.raw.en397,R.raw.en398,R.raw.en399,R.raw.en400
            ,R.raw.en401,R.raw.en402,R.raw.en403,R.raw.en404,R.raw.en405,R.raw.en406,R.raw.en407,R.raw.en408,R.raw.en409,R.raw.en410
            ,R.raw.en411,R.raw.en412,R.raw.en413,R.raw.en414,R.raw.en415,R.raw.en416,R.raw.en417,R.raw.en418,R.raw.en419,R.raw.en420
            ,R.raw.en421,R.raw.en422,R.raw.en423,R.raw.en424,R.raw.en425,R.raw.en426,R.raw.en427,R.raw.en428,R.raw.en429,R.raw.en430
            ,R.raw.en431,R.raw.en432,R.raw.en433,R.raw.en434,R.raw.en435,R.raw.en436,R.raw.en437,R.raw.en438,R.raw.en439,R.raw.en440
            ,R.raw.en441,R.raw.en442,R.raw.en443,R.raw.en444,R.raw.en445,R.raw.en446,R.raw.en447,R.raw.en448,R.raw.en449,R.raw.en450
            ,R.raw.en451,R.raw.en452,R.raw.en453,R.raw.en454,R.raw.en455,R.raw.en456,R.raw.en457,R.raw.en458,R.raw.en459,R.raw.en460
            ,R.raw.en461,R.raw.en462,R.raw.en463,R.raw.en464,R.raw.en465,R.raw.en466,R.raw.en467,R.raw.en468,R.raw.en469,R.raw.en470
            ,R.raw.en471,R.raw.en472,R.raw.en473,R.raw.en474,R.raw.en475,R.raw.en476,R.raw.en477,R.raw.en478,R.raw.en479,R.raw.en480
            ,R.raw.en481,R.raw.en482,R.raw.en483,R.raw.en484,R.raw.en485,R.raw.en486,R.raw.en487,R.raw.en488,R.raw.en489,R.raw.en490
            ,R.raw.en491,R.raw.en492,R.raw.en493,R.raw.en494,R.raw.en495,R.raw.en496,R.raw.en497,R.raw.en498,R.raw.en499,R.raw.en500
            ,R.raw.en501,R.raw.en502,R.raw.en503,R.raw.en504,R.raw.en505,R.raw.en506,R.raw.en507,R.raw.en508,R.raw.en509,R.raw.en510
            ,R.raw.en511,R.raw.en512,R.raw.en513,R.raw.en514,R.raw.en515,R.raw.en516,R.raw.en517,R.raw.en518,R.raw.en519,R.raw.en520
            ,R.raw.en521,R.raw.en522,R.raw.en523,R.raw.en524,R.raw.en525,R.raw.en526,R.raw.en527,R.raw.en528,R.raw.en529,R.raw.en530
            ,R.raw.en531,R.raw.en532,R.raw.en533,R.raw.en534,R.raw.en535,R.raw.en536,R.raw.en537,R.raw.en538,R.raw.en539,R.raw.en540
            ,R.raw.en541,R.raw.en542,R.raw.en543,R.raw.en544,R.raw.en545,R.raw.en546,R.raw.en547,R.raw.en548,R.raw.en549,R.raw.en550
            ,R.raw.en551,R.raw.en552,R.raw.en553,R.raw.en554,R.raw.en555,R.raw.en556,R.raw.en557,R.raw.en558,R.raw.en559,R.raw.en560
            ,R.raw.en561,R.raw.en562,R.raw.en563,R.raw.en564,R.raw.en565,R.raw.en566,R.raw.en567,R.raw.en568,R.raw.en569,R.raw.en570
            ,R.raw.en571,R.raw.en572,R.raw.en573,R.raw.en574,R.raw.en575,R.raw.en576,R.raw.en577,R.raw.en578,R.raw.en579,R.raw.en580
            ,R.raw.en581,R.raw.en582,R.raw.en583,R.raw.en584,R.raw.en585,R.raw.en586,R.raw.en587,R.raw.en588,R.raw.en589,R.raw.en590
            ,R.raw.en591,R.raw.en592,R.raw.en593,R.raw.en594,R.raw.en595,R.raw.en596,R.raw.en597,R.raw.en598,R.raw.en599,R.raw.en600
            ,R.raw.en601,R.raw.en602,R.raw.en603,R.raw.en604,R.raw.en605,R.raw.en606,R.raw.en607,R.raw.en608,R.raw.en609,R.raw.en610
            ,R.raw.en611,R.raw.en612,R.raw.en613,R.raw.en614,R.raw.en615,R.raw.en616,R.raw.en617,R.raw.en618,R.raw.en619,R.raw.en620
            ,R.raw.en621,R.raw.en622,R.raw.en623,R.raw.en624,R.raw.en625,R.raw.en626,R.raw.en627,R.raw.en628,R.raw.en629,R.raw.en630
            ,R.raw.en631,R.raw.en632,R.raw.en633,R.raw.en634,R.raw.en635,R.raw.en636,R.raw.en637,R.raw.en638,R.raw.en639,R.raw.en640
            ,R.raw.en641,R.raw.en642,R.raw.en643,R.raw.en644,R.raw.en645,R.raw.en646,R.raw.en647,R.raw.en648,R.raw.en649,R.raw.en650
            ,R.raw.en651,R.raw.en652,R.raw.en653,R.raw.en654,R.raw.en655,R.raw.en656,R.raw.en657,R.raw.en658,R.raw.en659,R.raw.en660
            ,R.raw.en661,R.raw.en662,R.raw.en663,R.raw.en664,R.raw.en665,R.raw.en666,R.raw.en667,R.raw.en668,R.raw.en669,R.raw.en670
            ,R.raw.en671,R.raw.en672,R.raw.en673,R.raw.en674,R.raw.en675,R.raw.en676,R.raw.en677,R.raw.en678,R.raw.en679,R.raw.en680
            ,R.raw.en681,R.raw.en682,R.raw.en683,R.raw.en684,R.raw.en685,R.raw.en686,R.raw.en687,R.raw.en688,R.raw.en689,R.raw.en690
            ,R.raw.en691,R.raw.en692,R.raw.en693,R.raw.en694,R.raw.en695,R.raw.en696,R.raw.en697,R.raw.en698,R.raw.en699,R.raw.en700
            ,R.raw.en701,R.raw.en702,R.raw.en703,R.raw.en704,R.raw.en705,R.raw.en706,R.raw.en707,R.raw.en708,R.raw.en709,R.raw.en710
            ,R.raw.en711,R.raw.en712,R.raw.en713,R.raw.en714,R.raw.en715,R.raw.en716,R.raw.en717,R.raw.en718,R.raw.en719,R.raw.en720
            ,R.raw.en721,R.raw.en722,R.raw.en723,R.raw.en724,R.raw.en725,R.raw.en726,R.raw.en727,R.raw.en728,R.raw.en729,R.raw.en730
            ,R.raw.en731,R.raw.en732,R.raw.en733,R.raw.en734,R.raw.en735,R.raw.en736,R.raw.en737,R.raw.en738,R.raw.en739,R.raw.en740
            ,R.raw.en741,R.raw.en742,R.raw.en743,R.raw.en744,R.raw.en745,R.raw.en746,R.raw.en747,R.raw.en748,R.raw.en749,R.raw.en750
            ,R.raw.en751,R.raw.en752,R.raw.en753,R.raw.en754,R.raw.en755,R.raw.en756,R.raw.en757,R.raw.en758,R.raw.en759,R.raw.en760
            ,R.raw.en761,R.raw.en762,R.raw.en763,R.raw.en764,R.raw.en765,R.raw.en766,R.raw.en767,R.raw.en768,R.raw.en769,R.raw.en770
            ,R.raw.en771,R.raw.en772,R.raw.en773,R.raw.en774,R.raw.en775,R.raw.en776,R.raw.en777,R.raw.en778,R.raw.en779,R.raw.en780
            ,R.raw.en781,R.raw.en782,R.raw.en783,R.raw.en784,R.raw.en785,R.raw.en786,R.raw.en787,R.raw.en788,R.raw.en789,R.raw.en790
            ,R.raw.en791,R.raw.en792,R.raw.en793,R.raw.en794,R.raw.en795,R.raw.en796,R.raw.en797,R.raw.en798,R.raw.en799,R.raw.en800
            ,R.raw.en801,R.raw.en802,R.raw.en803,R.raw.en804,R.raw.en805,R.raw.en806,R.raw.en807,R.raw.en808,R.raw.en809,R.raw.en810
            ,R.raw.en811,R.raw.en812,R.raw.en813,R.raw.en814,R.raw.en815,R.raw.en816,R.raw.en817,R.raw.en818,R.raw.en819,R.raw.en820
            ,R.raw.en821,R.raw.en822,R.raw.en823,R.raw.en824,R.raw.en825,R.raw.en826,R.raw.en827,R.raw.en828,R.raw.en829,R.raw.en830
            ,R.raw.en831,R.raw.en832,R.raw.en833,R.raw.en834,R.raw.en835,R.raw.en836,R.raw.en837,R.raw.en838,R.raw.en839,R.raw.en840
            ,R.raw.en841,R.raw.en842,R.raw.en843,R.raw.en844,R.raw.en845,R.raw.en846,R.raw.en847,R.raw.en848,R.raw.en849,R.raw.en850
            ,R.raw.en851,R.raw.en852,R.raw.en853,R.raw.en854,R.raw.en855,R.raw.en856,R.raw.en857,R.raw.en858,R.raw.en859,R.raw.en860
            ,R.raw.en861,R.raw.en862,R.raw.en863,R.raw.en864,R.raw.en865,R.raw.en866,R.raw.en867,R.raw.en868,R.raw.en869,R.raw.en870
            ,R.raw.en871,R.raw.en872,R.raw.en873,R.raw.en874,R.raw.en875,R.raw.en876,R.raw.en877,R.raw.en878,R.raw.en879,R.raw.en880
            ,R.raw.en881,R.raw.en882,R.raw.en883,R.raw.en884,R.raw.en885,R.raw.en886,R.raw.en887,R.raw.en888,R.raw.en889,R.raw.en890
            ,R.raw.en891,R.raw.en892,R.raw.en893,R.raw.en894,R.raw.en895,R.raw.en896,R.raw.en897,R.raw.en898,R.raw.en899,R.raw.en900
            ,R.raw.en901,R.raw.en902,R.raw.en903,R.raw.en904,R.raw.en905,R.raw.en906,R.raw.en907,R.raw.en908,R.raw.en909,R.raw.en910
            ,R.raw.en911,R.raw.en912,R.raw.en913,R.raw.en914,R.raw.en915,R.raw.en916,R.raw.en917,R.raw.en918,R.raw.en919,R.raw.en920
            ,R.raw.en921,R.raw.en922,R.raw.en923,R.raw.en924,R.raw.en925,R.raw.en926,R.raw.en927,R.raw.en928,R.raw.en929,R.raw.en930
            ,R.raw.en931,R.raw.en932,R.raw.en933,R.raw.en934,R.raw.en935,R.raw.en936,R.raw.en937,R.raw.en938,R.raw.en939,R.raw.en940
            ,R.raw.en941,R.raw.en942,R.raw.en943,R.raw.en944,R.raw.en945,R.raw.en946,R.raw.en947,R.raw.en948,R.raw.en949,R.raw.en950
            ,R.raw.en951,R.raw.en952,R.raw.en953,R.raw.en954,R.raw.en955,R.raw.en956,R.raw.en957,R.raw.en958,R.raw.en959,R.raw.en960
            ,R.raw.en961,R.raw.en962,R.raw.en963,R.raw.en964,R.raw.en965,R.raw.en966,R.raw.en967,R.raw.en968,R.raw.en969,R.raw.en970
            ,R.raw.en971,R.raw.en972,R.raw.en973,R.raw.en974,R.raw.en975,R.raw.en976,R.raw.en977,R.raw.en978,R.raw.en979,R.raw.en980
            ,R.raw.en981,R.raw.en982,R.raw.en983,R.raw.en984,R.raw.en985,R.raw.en986,R.raw.en987,R.raw.en988,R.raw.en989,R.raw.en990
            ,R.raw.en991,R.raw.en992,R.raw.en993,R.raw.en994,R.raw.en995,R.raw.en996,R.raw.en997,R.raw.en998,R.raw.en999,R.raw.en1000
            ,R.raw.en1001,R.raw.en1002,R.raw.en1003,R.raw.en1004,R.raw.en1005,R.raw.en1006,R.raw.en1007,R.raw.en1008,R.raw.en1009,R.raw.en1010
            ,R.raw.en1011,R.raw.en1012,R.raw.en1013,R.raw.en1014,R.raw.en1015,R.raw.en1016,R.raw.en1017,R.raw.en1018,R.raw.en1019,R.raw.en1020
            ,R.raw.en1021,R.raw.en1022,R.raw.en1023,R.raw.en1024,R.raw.en1025,R.raw.en1026,R.raw.en1027,R.raw.en1028,R.raw.en1029,R.raw.en1030
            ,R.raw.en1031,R.raw.en1032,R.raw.en1033,R.raw.en1034,R.raw.en1035,R.raw.en1036,R.raw.en1037,R.raw.en1038,R.raw.en1039,R.raw.en1040
            ,R.raw.en1041,R.raw.en1042,R.raw.en1043,R.raw.en1044,R.raw.en1045,R.raw.en1046,R.raw.en1047,R.raw.en1048,R.raw.en1049,R.raw.en1050
            ,R.raw.en1051,R.raw.en1052,R.raw.en1053,R.raw.en1054,R.raw.en1055,R.raw.en1056,R.raw.en1057,R.raw.en1058,R.raw.en1059,R.raw.en1060
            ,R.raw.en1061,R.raw.en1062,R.raw.en1063,R.raw.en1064,R.raw.en1065,R.raw.en1066,R.raw.en1067,R.raw.en1068,R.raw.en1069,R.raw.en1070
            ,R.raw.en1071,R.raw.en1072,R.raw.en1073,R.raw.en1074,R.raw.en1075,R.raw.en1076,R.raw.en1077,R.raw.en1078,R.raw.en1079,R.raw.en1080
            ,R.raw.en1081,R.raw.en1082,R.raw.en1083,R.raw.en1084,R.raw.en1085,R.raw.en1086,R.raw.en1087,R.raw.en1088,R.raw.en1089,R.raw.en1090
            ,R.raw.en1091,R.raw.en1092,R.raw.en1093,R.raw.en1094,R.raw.en1095,R.raw.en1096,R.raw.en1097,R.raw.en1098,R.raw.en1099,R.raw.en1100
            ,R.raw.en1101,R.raw.en1102,R.raw.en1103,R.raw.en1104,R.raw.en1105,R.raw.en1106,R.raw.en1107,R.raw.en1108,R.raw.en1109,R.raw.en1110
            ,R.raw.en1111,R.raw.en1112,R.raw.en1113,R.raw.en1114,R.raw.en1115,R.raw.en1116,R.raw.en1117,R.raw.en1118,R.raw.en1119,R.raw.en1120
            ,R.raw.en1121,R.raw.en1122,R.raw.en1123,R.raw.en1124,R.raw.en1125,R.raw.en1126,R.raw.en1127,R.raw.en1128,R.raw.en1129,R.raw.en1130
            ,R.raw.en1131,R.raw.en1132,R.raw.en1133,R.raw.en1134,R.raw.en1135,R.raw.en1136,R.raw.en1137,R.raw.en1138,R.raw.en1139,R.raw.en1140
            ,R.raw.en1141,R.raw.en1142,R.raw.en1143,R.raw.en1144,R.raw.en1145,R.raw.en1146,R.raw.en1147,R.raw.en1148,R.raw.en1149,R.raw.en1150
            ,R.raw.en1151,R.raw.en1152,R.raw.en1153,R.raw.en1154,R.raw.en1155,R.raw.en1156,R.raw.en1157,R.raw.en1158,R.raw.en1159,R.raw.en1160
            ,R.raw.en1161,R.raw.en1162,R.raw.en1163,R.raw.en1164,R.raw.en1165,R.raw.en1166,R.raw.en1167,R.raw.en1168,R.raw.en1169,R.raw.en1170
            ,R.raw.en1171,R.raw.en1172,R.raw.en1173,R.raw.en1174,R.raw.en1175,R.raw.en1176,R.raw.en1177,R.raw.en1178,R.raw.en1179,R.raw.en1180
            ,R.raw.en1181,R.raw.en1182,R.raw.en1183,R.raw.en1184,R.raw.en1185,R.raw.en1186,R.raw.en1187,R.raw.en1188,R.raw.en1189,R.raw.en1190
            ,R.raw.en1191,R.raw.en1192,R.raw.en1193,R.raw.en1194,R.raw.en1195,R.raw.en1196,R.raw.en1197,R.raw.en1198,R.raw.en1199,R.raw.en1200
            ,R.raw.en1201,R.raw.en1202,R.raw.en1203,R.raw.en1204,R.raw.en1205,R.raw.en1206,R.raw.en1207,R.raw.en1208,R.raw.en1209,R.raw.en1210
            ,R.raw.en1211,R.raw.en1212,R.raw.en1213,R.raw.en1214,R.raw.en1215,R.raw.en1216,R.raw.en1217,R.raw.en1218,R.raw.en1219,R.raw.en1220
            ,R.raw.en1221,R.raw.en1222,R.raw.en1223,R.raw.en1224,R.raw.en1225,R.raw.en1226,R.raw.en1227,R.raw.en1228,R.raw.en1229,R.raw.en1230
            ,R.raw.en1231,R.raw.en1232,R.raw.en1233,R.raw.en1234,R.raw.en1235,R.raw.en1236,R.raw.en1237,R.raw.en1238,R.raw.en1239,R.raw.en1240
            ,R.raw.en1241,R.raw.en1242,R.raw.en1243,R.raw.en1244,R.raw.en1245,R.raw.en1246,R.raw.en1247,R.raw.en1248,R.raw.en1249,R.raw.en1250
            ,R.raw.en1251,R.raw.en1252,R.raw.en1253,R.raw.en1254,R.raw.en1255,R.raw.en1256,R.raw.en1257,R.raw.en1258,R.raw.en1259,R.raw.en1260
            ,R.raw.en1261,R.raw.en1262,R.raw.en1263,R.raw.en1264,R.raw.en1265,R.raw.en1266,R.raw.en1267,R.raw.en1268,R.raw.en1269,R.raw.en1270
            ,R.raw.en1271,R.raw.en1272,R.raw.en1273,R.raw.en1274,R.raw.en1275,R.raw.en1276,R.raw.en1277,R.raw.en1278,R.raw.en1279,R.raw.en1280
            ,R.raw.en1281,R.raw.en1282,R.raw.en1283,R.raw.en1284,R.raw.en1285,R.raw.en1286,R.raw.en1287,R.raw.en1288,R.raw.en1289,R.raw.en1290
            ,R.raw.en1291,R.raw.en1292,R.raw.en1293,R.raw.en1294,R.raw.en1295,R.raw.en1296,R.raw.en1297,R.raw.en1298,R.raw.en1299,R.raw.en1300
            ,R.raw.en1301,R.raw.en1302,R.raw.en1303,R.raw.en1304,R.raw.en1305,R.raw.en1306,R.raw.en1307,R.raw.en1308,R.raw.en1309,R.raw.en1310
            ,R.raw.en1311,R.raw.en1312,R.raw.en1313,R.raw.en1314,R.raw.en1315,R.raw.en1316,R.raw.en1317,R.raw.en1318,R.raw.en1319,R.raw.en1320
            ,R.raw.en1321,R.raw.en1322,R.raw.en1323,R.raw.en1324,R.raw.en1325,R.raw.en1326,R.raw.en1327,R.raw.en1328,R.raw.en1329,R.raw.en1330
            ,R.raw.en1331,R.raw.en1332,R.raw.en1333,R.raw.en1334,R.raw.en1335,R.raw.en1336,R.raw.en1337,R.raw.en1338,R.raw.en1339,R.raw.en1340
            ,R.raw.en1341,R.raw.en1342,R.raw.en1343,R.raw.en1344,R.raw.en1345,R.raw.en1346,R.raw.en1347,R.raw.en1348,R.raw.en1349,R.raw.en1350
            ,R.raw.en1351,R.raw.en1352,R.raw.en1353,R.raw.en1354,R.raw.en1355,R.raw.en1356,R.raw.en1357,R.raw.en1358,R.raw.en1359,R.raw.en1360
            ,R.raw.en1361,R.raw.en1362,R.raw.en1363,R.raw.en1364,R.raw.en1365,R.raw.en1366,R.raw.en1367,R.raw.en1368,R.raw.en1369,R.raw.en1370
            ,R.raw.en1371,R.raw.en1372,R.raw.en1373,R.raw.en1374,R.raw.en1375,R.raw.en1376,R.raw.en1377,R.raw.en1378,R.raw.en1379,R.raw.en1380
            ,R.raw.en1381,R.raw.en1382,R.raw.en1383,R.raw.en1384,R.raw.en1385,R.raw.en1386,R.raw.en1387,R.raw.en1388,R.raw.en1389,R.raw.en1390
            ,R.raw.en1391,R.raw.en1392,R.raw.en1393,R.raw.en1394,R.raw.en1395,R.raw.en1396,R.raw.en1397,R.raw.en1398,R.raw.en1399,R.raw.en1400
            ,R.raw.en1401,R.raw.en1402,R.raw.en1403,R.raw.en1404,R.raw.en1405,R.raw.en1406,R.raw.en1407,R.raw.en1408,R.raw.en1409,R.raw.en1410
            ,R.raw.en1411,R.raw.en1412,R.raw.en1413,R.raw.en1414,R.raw.en1415,R.raw.en1416,R.raw.en1417,R.raw.en1418,R.raw.en1419,R.raw.en1420
            ,R.raw.en1421,R.raw.en1422,R.raw.en1423,R.raw.en1424,R.raw.en1425,R.raw.en1426,R.raw.en1427,R.raw.en1428,R.raw.en1429,R.raw.en1430
            ,R.raw.en1431,R.raw.en1432,R.raw.en1433,R.raw.en1434,R.raw.en1435,R.raw.en1436,R.raw.en1437,R.raw.en1438,R.raw.en1439,R.raw.en1440
            ,R.raw.en1441,R.raw.en1442,R.raw.en1443,R.raw.en1444,R.raw.en1445,R.raw.en1446,R.raw.en1447,R.raw.en1448,R.raw.en1449,R.raw.en1450
            ,R.raw.en1451,R.raw.en1452,R.raw.en1453,R.raw.en1454,R.raw.en1455,R.raw.en1456,R.raw.en1457,R.raw.en1458,R.raw.en1459,R.raw.en1460
            ,R.raw.en1461,R.raw.en1462,R.raw.en1463,R.raw.en1464,R.raw.en1465,R.raw.en1466,R.raw.en1467,R.raw.en1468,R.raw.en1469,R.raw.en1470
            ,R.raw.en1471,R.raw.en1472,R.raw.en1473,R.raw.en1474,R.raw.en1475,R.raw.en1476,R.raw.en1477,R.raw.en1478,R.raw.en1479,R.raw.en1480
            ,R.raw.en1481,R.raw.en1482,R.raw.en1483,R.raw.en1484,R.raw.en1485,R.raw.en1486,R.raw.en1487,R.raw.en1488,R.raw.en1489,R.raw.en1490
            ,R.raw.en1491,R.raw.en1492,R.raw.en1493,R.raw.en1494,R.raw.en1495,R.raw.en1496,R.raw.en1497,R.raw.en1498,R.raw.en1499,R.raw.en1500
            ,R.raw.en1501,R.raw.en1502,R.raw.en1503,R.raw.en1504,R.raw.en1505,R.raw.en1506,R.raw.en1507,R.raw.en1508,R.raw.en1509,R.raw.en1510
            ,R.raw.en1511,R.raw.en1512,R.raw.en1513,R.raw.en1514,R.raw.en1515,R.raw.en1516,R.raw.en1517,R.raw.en1518,R.raw.en1519,R.raw.en1520
            ,R.raw.en1521,R.raw.en1522,R.raw.en1523,R.raw.en1524,R.raw.en1525,R.raw.en1526,R.raw.en1527,R.raw.en1528,R.raw.en1529,R.raw.en1530
            ,R.raw.en1531,R.raw.en1532,R.raw.en1533,R.raw.en1534,R.raw.en1535,R.raw.en1536,R.raw.en1537,R.raw.en1538,R.raw.en1539,R.raw.en1540
            ,R.raw.en1541,R.raw.en1542,R.raw.en1543,R.raw.en1544,R.raw.en1545,R.raw.en1546,R.raw.en1547,R.raw.en1548,R.raw.en1549,R.raw.en1550
            ,R.raw.en1551,R.raw.en1552,R.raw.en1553,R.raw.en1554,R.raw.en1555,R.raw.en1556,R.raw.en1557,R.raw.en1558,R.raw.en1559,R.raw.en1560
            ,R.raw.en1561,R.raw.en1562,R.raw.en1563,R.raw.en1564,R.raw.en1565,R.raw.en1566,R.raw.en1567,R.raw.en1568,R.raw.en1569,R.raw.en1570
            ,R.raw.en1571,R.raw.en1572,R.raw.en1573,R.raw.en1574,R.raw.en1575,R.raw.en1576,R.raw.en1577,R.raw.en1578,R.raw.en1579,R.raw.en1580
            ,R.raw.en1581,R.raw.en1582,R.raw.en1583,R.raw.en1584,R.raw.en1585,R.raw.en1586,R.raw.en1587,R.raw.en1588,R.raw.en1589,R.raw.en1590
            ,R.raw.en1591,R.raw.en1592,R.raw.en1593,R.raw.en1594,R.raw.en1595,R.raw.en1596,R.raw.en1597,R.raw.en1598,R.raw.en1599,R.raw.en1600
            ,R.raw.en1601,R.raw.en1602,R.raw.en1603,R.raw.en1604,R.raw.en1605,R.raw.en1606,R.raw.en1607,R.raw.en1608,R.raw.en1609,R.raw.en1610
            ,R.raw.en1611,R.raw.en1612,R.raw.en1613,R.raw.en1614,R.raw.en1615,R.raw.en1616,R.raw.en1617,R.raw.en1618,R.raw.en1619,R.raw.en1620
            ,R.raw.en1621,R.raw.en1622,R.raw.en1623,R.raw.en1624,R.raw.en1625,R.raw.en1626,R.raw.en1627,R.raw.en1628,R.raw.en1629,R.raw.en1630
            ,R.raw.en1631,R.raw.en1632,R.raw.en1633,R.raw.en1634,R.raw.en1635,R.raw.en1636,R.raw.en1637,R.raw.en1638,R.raw.en1639,R.raw.en1640
            ,R.raw.en1641,R.raw.en1642,R.raw.en1643,R.raw.en1644,R.raw.en1645,R.raw.en1646,R.raw.en1647,R.raw.en1648,R.raw.en1649,R.raw.en1650
            ,R.raw.en1651,R.raw.en1652,R.raw.en1653,R.raw.en1654,R.raw.en1655,R.raw.en1656,R.raw.en1657,R.raw.en1658,R.raw.en1659,R.raw.en1660
            ,R.raw.en1661,R.raw.en1662,R.raw.en1663,R.raw.en1664,R.raw.en1665,R.raw.en1666,R.raw.en1667,R.raw.en1668,R.raw.en1669,R.raw.en1670
            ,R.raw.en1671,R.raw.en1672,R.raw.en1673,R.raw.en1674,R.raw.en1675,R.raw.en1676,R.raw.en1677,R.raw.en1678,R.raw.en1679,R.raw.en1680
            ,R.raw.en1681,R.raw.en1682,R.raw.en1683,R.raw.en1684,R.raw.en1685,R.raw.en1686,R.raw.en1687,R.raw.en1688,R.raw.en1689,R.raw.en1690
            ,R.raw.en1691,R.raw.en1692,R.raw.en1693,R.raw.en1694,R.raw.en1695,R.raw.en1696,R.raw.en1697,R.raw.en1698,R.raw.en1699,R.raw.en1700
            ,R.raw.en1701,R.raw.en1702,R.raw.en1703,R.raw.en1704,R.raw.en1705,R.raw.en1706,R.raw.en1707,R.raw.en1708,R.raw.en1709,R.raw.en1710
            ,R.raw.en1711,R.raw.en1712,R.raw.en1713,R.raw.en1714,R.raw.en1715,R.raw.en1716,R.raw.en1717,R.raw.en1718,R.raw.en1719,R.raw.en1720
            ,R.raw.en1721,R.raw.en1722,R.raw.en1723,R.raw.en1724,R.raw.en1725,R.raw.en1726,R.raw.en1727,R.raw.en1728,R.raw.en1729,R.raw.en1730
            ,R.raw.en1731,R.raw.en1732,R.raw.en1733,R.raw.en1734,R.raw.en1735,R.raw.en1736,R.raw.en1737,R.raw.en1738,R.raw.en1739,R.raw.en1740
            ,R.raw.en1741,R.raw.en1742,R.raw.en1743,R.raw.en1744,R.raw.en1745,R.raw.en1746,R.raw.en1747,R.raw.en1748,R.raw.en1749,R.raw.en1750
            ,R.raw.en1751,R.raw.en1752,R.raw.en1753,R.raw.en1754,R.raw.en1755,R.raw.en1756,R.raw.en1757,R.raw.en1758,R.raw.en1759,R.raw.en1760
            ,R.raw.en1761,R.raw.en1762,R.raw.en1763,R.raw.en1764,R.raw.en1765,R.raw.en1766,R.raw.en1767,R.raw.en1768,R.raw.en1769,R.raw.en1770
            ,R.raw.en1771,R.raw.en1772,R.raw.en1773,R.raw.en1774,R.raw.en1775,R.raw.en1776,R.raw.en1777,R.raw.en1778,R.raw.en1779,R.raw.en1780
            ,R.raw.en1781,R.raw.en1782,R.raw.en1783,R.raw.en1784,R.raw.en1785,R.raw.en1786,R.raw.en1787,R.raw.en1788,R.raw.en1789,R.raw.en1790
            ,R.raw.en1791,R.raw.en1792,R.raw.en1793,R.raw.en1794,R.raw.en1795,R.raw.en1796,R.raw.en1797,R.raw.en1798,R.raw.en1799,R.raw.en1800
            ,R.raw.en1801,R.raw.en1802,R.raw.en1803,R.raw.en1804,R.raw.en1805,R.raw.en1806,R.raw.en1807,R.raw.en1808,R.raw.en1809,R.raw.en1810
            ,R.raw.en1811,R.raw.en1812,R.raw.en1813,R.raw.en1814,R.raw.en1815,R.raw.en1816,R.raw.en1817,R.raw.en1818,R.raw.en1819,R.raw.en1820
            ,R.raw.en1821,R.raw.en1822,R.raw.en1823,R.raw.en1824,R.raw.en1825,R.raw.en1826,R.raw.en1827,R.raw.en1828,R.raw.en1829,R.raw.en1830
            ,R.raw.en1831,R.raw.en1832,R.raw.en1833,R.raw.en1834,R.raw.en1835,R.raw.en1836,R.raw.en1837,R.raw.en1838,R.raw.en1839,R.raw.en1840
            ,R.raw.en1841,R.raw.en1842,R.raw.en1843,R.raw.en1844,R.raw.en1845,R.raw.en1846,R.raw.en1847,R.raw.en1848,R.raw.en1849,R.raw.en1850
            ,R.raw.en1851,R.raw.en1852,R.raw.en1853,R.raw.en1854,R.raw.en1855,R.raw.en1856,R.raw.en1857,R.raw.en1858,R.raw.en1859,R.raw.en1860
            ,R.raw.en1861,R.raw.en1862,R.raw.en1863,R.raw.en1864,R.raw.en1865,R.raw.en1866,R.raw.en1867,R.raw.en1868,R.raw.en1869,R.raw.en1870
            ,R.raw.en1871,R.raw.en1872,R.raw.en1873,R.raw.en1874,R.raw.en1875,R.raw.en1876,R.raw.en1877,R.raw.en1878,R.raw.en1879,R.raw.en1880
            ,R.raw.en1881,R.raw.en1882,R.raw.en1883,R.raw.en1884,R.raw.en1885,R.raw.en1886,R.raw.en1887,R.raw.en1888,R.raw.en1889,R.raw.en1890
            ,R.raw.en1891,R.raw.en1892,R.raw.en1893,R.raw.en1894,R.raw.en1895,R.raw.en1896,R.raw.en1897,R.raw.en1898,R.raw.en1899,R.raw.en1900
            ,R.raw.en1901,R.raw.en1902,R.raw.en1903,R.raw.en1904,R.raw.en1905,R.raw.en1906,R.raw.en1907,R.raw.en1908,R.raw.en1909,R.raw.en1910
            ,R.raw.en1911,R.raw.en1912,R.raw.en1913,R.raw.en1914,R.raw.en1915,R.raw.en1916,R.raw.en1917,R.raw.en1918,R.raw.en1919,R.raw.en1920
            ,R.raw.en1921,R.raw.en1922,R.raw.en1923,R.raw.en1924,R.raw.en1925,R.raw.en1926,R.raw.en1927,R.raw.en1928,R.raw.en1929,R.raw.en1930
            ,R.raw.en1931,R.raw.en1932,R.raw.en1933,R.raw.en1934,R.raw.en1935,R.raw.en1936,R.raw.en1937,R.raw.en1938,R.raw.en1939,R.raw.en1940
            ,R.raw.en1941,R.raw.en1942,R.raw.en1943,R.raw.en1944,R.raw.en1945,R.raw.en1946,R.raw.en1947,R.raw.en1948,R.raw.en1949,R.raw.en1950
            ,R.raw.en1951,R.raw.en1952,R.raw.en1953,R.raw.en1954,R.raw.en1955,R.raw.en1956,R.raw.en1957,R.raw.en1958,R.raw.en1959,R.raw.en1960
            ,R.raw.en1961,R.raw.en1962,R.raw.en1963,R.raw.en1964,R.raw.en1965,R.raw.en1966,R.raw.en1967,R.raw.en1968,R.raw.en1969,R.raw.en1970
            ,R.raw.en1971,R.raw.en1972,R.raw.en1973,R.raw.en1974,R.raw.en1975,R.raw.en1976,R.raw.en1977,R.raw.en1978,R.raw.en1979,R.raw.en1980
            ,R.raw.en1981,R.raw.en1982,R.raw.en1983,R.raw.en1984,R.raw.en1985,R.raw.en1986,R.raw.en1987,R.raw.en1988,R.raw.en1989,R.raw.en1990
            ,R.raw.en1991,R.raw.en1992,R.raw.en1993,R.raw.en1994,R.raw.en1995,R.raw.en1996,R.raw.en1997,R.raw.en1998,R.raw.en1999,R.raw.en2000
            ,R.raw.en2001,R.raw.en2002,R.raw.en2003,R.raw.en2004,R.raw.en2005,R.raw.en2006,R.raw.en2007,R.raw.en2008,R.raw.en2009,R.raw.en2010
            ,R.raw.en2011,R.raw.en2012,R.raw.en2013,R.raw.en2014,R.raw.en2015,R.raw.en2016,R.raw.en2017,R.raw.en2018,R.raw.en2019,R.raw.en2020
            ,R.raw.en2021,R.raw.en2022,R.raw.en2023,R.raw.en2024,R.raw.en2025,R.raw.en2026,R.raw.en2027,R.raw.en2028,R.raw.en2029,R.raw.en2030
            ,R.raw.en2031,R.raw.en2032,R.raw.en2033,R.raw.en2034,R.raw.en2035,R.raw.en2036,R.raw.en2037,R.raw.en2038,R.raw.en2039,R.raw.en2040
            ,R.raw.en2041,R.raw.en2042,R.raw.en2043,R.raw.en2044,R.raw.en2045,R.raw.en2046,R.raw.en2047,R.raw.en2048,R.raw.en2049,R.raw.en2050
            ,R.raw.en2051,R.raw.en2052,R.raw.en2053,R.raw.en2054,R.raw.en2055,R.raw.en2056,R.raw.en2057,R.raw.en2058,R.raw.en2059,R.raw.en2060
            ,R.raw.en2061,R.raw.en2062,R.raw.en2063,R.raw.en2064,R.raw.en2065,R.raw.en2066,R.raw.en2067,R.raw.en2068,R.raw.en2069,R.raw.en2070
            ,R.raw.en2071,R.raw.en2072,R.raw.en2073,R.raw.en2074,R.raw.en2075,R.raw.en2076,R.raw.en2077,R.raw.en2078,R.raw.en2079,R.raw.en2080
            ,R.raw.en2081,R.raw.en2082,R.raw.en2083,R.raw.en2084,R.raw.en2085,R.raw.en2086,R.raw.en2087,R.raw.en2088,R.raw.en2089,R.raw.en2090
            ,R.raw.en2091,R.raw.en2092,R.raw.en2093,R.raw.en2094,R.raw.en2095,R.raw.en2096,R.raw.en2097,R.raw.en2098,R.raw.en2099,R.raw.en2100
            ,R.raw.en2101,R.raw.en2102,R.raw.en2103,R.raw.en2104,R.raw.en2105,R.raw.en2106,R.raw.en2107,R.raw.en2108,R.raw.en2109,R.raw.en2110
            ,R.raw.en2111,R.raw.en2112,R.raw.en2113,R.raw.en2114,R.raw.en2115,R.raw.en2116,R.raw.en2117,R.raw.en2118,R.raw.en2119,R.raw.en2120
            ,R.raw.en2121,R.raw.en2122,R.raw.en2123,R.raw.en2124,R.raw.en2125,R.raw.en2126,R.raw.en2127,R.raw.en2128,R.raw.en2129,R.raw.en2130
            ,R.raw.en2131,R.raw.en2132,R.raw.en2133,R.raw.en2134,R.raw.en2135,R.raw.en2136,R.raw.en2137,R.raw.en2138,R.raw.en2139,R.raw.en2140
            ,R.raw.en2141,R.raw.en2142,R.raw.en2143,R.raw.en2144,R.raw.en2145,R.raw.en2146,R.raw.en2147,R.raw.en2148,R.raw.en2149,R.raw.en2150
            ,R.raw.en2151,R.raw.en2152,R.raw.en2153,R.raw.en2154,R.raw.en2155,R.raw.en2156,R.raw.en2157,R.raw.en2158,R.raw.en2159,R.raw.en2160
            ,R.raw.en2161,R.raw.en2162,R.raw.en2163,R.raw.en2164,R.raw.en2165,R.raw.en2166,R.raw.en2167,R.raw.en2168,R.raw.en2169,R.raw.en2170
            ,R.raw.en2171,R.raw.en2172,R.raw.en2173,R.raw.en2174,R.raw.en2175,R.raw.en2176,R.raw.en2177,R.raw.en2178,R.raw.en2179,R.raw.en2180
            ,R.raw.en2181,R.raw.en2182,R.raw.en2183,R.raw.en2184,R.raw.en2185,R.raw.en2186,R.raw.en2187,R.raw.en2188,R.raw.en2189,R.raw.en2190
            ,R.raw.en2191,R.raw.en2192,R.raw.en2193,R.raw.en2194,R.raw.en2195,R.raw.en2196,R.raw.en2197,R.raw.en2198,R.raw.en2199,R.raw.en2200
            ,R.raw.en2201,R.raw.en2202,R.raw.en2203,R.raw.en2204,R.raw.en2205,R.raw.en2206,R.raw.en2207,R.raw.en2208,R.raw.en2209,R.raw.en2210
            ,R.raw.en2211,R.raw.en2212,R.raw.en2213,R.raw.en2214,R.raw.en2215,R.raw.en2216,R.raw.en2217,R.raw.en2218,R.raw.en2219,R.raw.en2220
            ,R.raw.en2221,R.raw.en2222,R.raw.en2223,R.raw.en2224,R.raw.en2225,R.raw.en2226,R.raw.en2227,R.raw.en2228,R.raw.en2229,R.raw.en2230
            ,R.raw.en2231,R.raw.en2232,R.raw.en2233,R.raw.en2234,R.raw.en2235,R.raw.en2236,R.raw.en2237,R.raw.en2238,R.raw.en2239,R.raw.en2240
            ,R.raw.en2241,R.raw.en2242,R.raw.en2243,R.raw.en2244,R.raw.en2245,R.raw.en2246,R.raw.en2247,R.raw.en2248,R.raw.en2249,R.raw.en2250
            ,R.raw.en2251,R.raw.en2252,R.raw.en2253,R.raw.en2254,R.raw.en2255,R.raw.en2256,R.raw.en2257,R.raw.en2258,R.raw.en2259,R.raw.en2260
            ,R.raw.en2261,R.raw.en2262,R.raw.en2263,R.raw.en2264,R.raw.en2265,R.raw.en2266,R.raw.en2267,R.raw.en2268,R.raw.en2269,R.raw.en2270
            ,R.raw.en2271,R.raw.en2272,R.raw.en2273,R.raw.en2274,R.raw.en2275,R.raw.en2276,R.raw.en2277,R.raw.en2278,R.raw.en2279,R.raw.en2280
            ,R.raw.en2281,R.raw.en2282,R.raw.en2283,R.raw.en2284,R.raw.en2285,R.raw.en2286,R.raw.en2287,R.raw.en2288,R.raw.en2289,R.raw.en2290
            ,R.raw.en2291,R.raw.en2292,R.raw.en2293,R.raw.en2294,R.raw.en2295,R.raw.en2296,R.raw.en2297,R.raw.en2298,R.raw.en2299,R.raw.en2300
            ,R.raw.en2301,R.raw.en3202,R.raw.en2303,R.raw.en2304,R.raw.en2305,R.raw.en2306,R.raw.en2307,R.raw.en2308,R.raw.en2309,R.raw.en2310
            ,R.raw.en2311,R.raw.en2312,R.raw.en2313,R.raw.en2314,R.raw.en2315,R.raw.en2316,R.raw.en2317,R.raw.en2318,R.raw.en2319,R.raw.en2320
            ,R.raw.en2321,R.raw.en2322,R.raw.en2323,R.raw.en2324,R.raw.en2325,R.raw.en2326,R.raw.en2327,R.raw.en2328,R.raw.en2329,R.raw.en2330
            ,R.raw.en2331,R.raw.en2332,R.raw.en2333,R.raw.en2334,R.raw.en2335,R.raw.en2336,R.raw.en2337,R.raw.en2338,R.raw.en2339,R.raw.en2340
            ,R.raw.en2341,R.raw.en2342,R.raw.en2343,R.raw.en2344,R.raw.en2345,R.raw.en2346,R.raw.en2347,R.raw.en2348,R.raw.en2349,R.raw.en2350
            ,R.raw.en2351,R.raw.en2352,R.raw.en2353,R.raw.en2354,R.raw.en2355,R.raw.en2356,R.raw.en2357,R.raw.en2358,R.raw.en2359,R.raw.en2360
            ,R.raw.en2361,R.raw.en2362,R.raw.en2363,R.raw.en2364,R.raw.en2365,R.raw.en2366,R.raw.en2367,R.raw.en2368,R.raw.en2369,R.raw.en2370
            ,R.raw.en2371,R.raw.en2372,R.raw.en2373,R.raw.en2374,R.raw.en2375,R.raw.en2376,R.raw.en2377,R.raw.en2378,R.raw.en2379,R.raw.en2380
            ,R.raw.en2381,R.raw.en2382,R.raw.en2383,R.raw.en2384,R.raw.en2385,R.raw.en2386,R.raw.en2387,R.raw.en2388,R.raw.en2389,R.raw.en2390
            ,R.raw.en2391,R.raw.en2392,R.raw.en2393,R.raw.en2394,R.raw.en2395,R.raw.en2396,R.raw.en2397,R.raw.en2398,R.raw.en2399,R.raw.en2400
            ,R.raw.en2401,R.raw.en2402,R.raw.en2403,R.raw.en2404,R.raw.en2405,R.raw.en2406,R.raw.en2407,R.raw.en2408,R.raw.en2409,R.raw.en2410
            ,R.raw.en2411,R.raw.en2412,R.raw.en2413,R.raw.en2414,R.raw.en2415,R.raw.en2416,R.raw.en2417,R.raw.en2418,R.raw.en2419,R.raw.en2420
            ,R.raw.en2421,R.raw.en2422,R.raw.en2423,R.raw.en2424,R.raw.en2425,R.raw.en2426,R.raw.en2427,R.raw.en2428,R.raw.en2429,R.raw.en2430
            ,R.raw.en2431,R.raw.en2432,R.raw.en2433,R.raw.en2434,R.raw.en2435,R.raw.en2436,R.raw.en2437,R.raw.en2438,R.raw.en2439,R.raw.en2440
            ,R.raw.en2441,R.raw.en2442,R.raw.en2443,R.raw.en2444,R.raw.en2445,R.raw.en2446,R.raw.en2447,R.raw.en2448,R.raw.en2449,R.raw.en2450
            ,R.raw.en2451,R.raw.en2452,R.raw.en2453,R.raw.en2454,R.raw.en2455,R.raw.en2456,R.raw.en2457,R.raw.en2458,R.raw.en2459,R.raw.en2460
            ,R.raw.en2461,R.raw.en2462,R.raw.en2463,R.raw.en2464,R.raw.en2465,R.raw.en2466,R.raw.en2467,R.raw.en2468,R.raw.en2469,R.raw.en2470
            ,R.raw.en2471,R.raw.en2472,R.raw.en2473,R.raw.en2474,R.raw.en2475,R.raw.en2476,R.raw.en2477,R.raw.en2478,R.raw.en2479,R.raw.en2480
            ,R.raw.en2481,R.raw.en2482,R.raw.en2483,R.raw.en2484,R.raw.en2485,R.raw.en2486,R.raw.en2487,R.raw.en2488,R.raw.en2489,R.raw.en2490
            ,R.raw.en2491,R.raw.en2492,R.raw.en2493,R.raw.en2494,R.raw.en2495,R.raw.en2496,R.raw.en2497,R.raw.en2498,R.raw.en2499,R.raw.en2500
            ,R.raw.en2501,R.raw.en2502,R.raw.en2503,R.raw.en2504,R.raw.en2505,R.raw.en2506,R.raw.en2507,R.raw.en2508,R.raw.en2509,R.raw.en2510
            ,R.raw.en2511,R.raw.en2512,R.raw.en2513,R.raw.en2514,R.raw.en2515,R.raw.en2516,R.raw.en2517,R.raw.en2518,R.raw.en2519,R.raw.en2520
            ,R.raw.en2521,R.raw.en2522,R.raw.en2523,R.raw.en2524,R.raw.en2525,R.raw.en2526,R.raw.en2527,R.raw.en2528,R.raw.en2529,R.raw.en2530
            ,R.raw.en2531,R.raw.en2532,R.raw.en2533,R.raw.en2534,R.raw.en2535,R.raw.en2536,R.raw.en2537,R.raw.en2538,R.raw.en2539,R.raw.en2540
            ,R.raw.en2541,R.raw.en2542,R.raw.en2543,R.raw.en2544,R.raw.en2545,R.raw.en2546,R.raw.en2547,R.raw.en2548,R.raw.en2549,R.raw.en2550
            ,R.raw.en2551,R.raw.en2552,R.raw.en2553,R.raw.en2554,R.raw.en2555,R.raw.en2556,R.raw.en2557,R.raw.en2558,R.raw.en2559,R.raw.en2560
            ,R.raw.en2561,R.raw.en2562,R.raw.en2563,R.raw.en2564,R.raw.en2565,R.raw.en2566,R.raw.en2567,R.raw.en2568,R.raw.en2569,R.raw.en2570
            ,R.raw.en2571,R.raw.en2572,R.raw.en2573,R.raw.en2574,R.raw.en2575,R.raw.en2576,R.raw.en2577,R.raw.en2578,R.raw.en2579,R.raw.en2580
            ,R.raw.en2581,R.raw.en2582,R.raw.en2583,R.raw.en2584,R.raw.en2585,R.raw.en2586,R.raw.en2587,R.raw.en2588,R.raw.en2589,R.raw.en2590
            ,R.raw.en2591,R.raw.en2592,R.raw.en2593,R.raw.en2594,R.raw.en2595,R.raw.en2596,R.raw.en2597,R.raw.en2598,R.raw.en2599,R.raw.en2600
            ,R.raw.en2601,R.raw.en2602,R.raw.en2603,R.raw.en2604,R.raw.en2605,R.raw.en2606,R.raw.en2607,R.raw.en2608,R.raw.en2609,R.raw.en2610
            ,R.raw.en2611,R.raw.en2612,R.raw.en2613,R.raw.en2614,R.raw.en2615,R.raw.en2616,R.raw.en2617,R.raw.en2618,R.raw.en2619,R.raw.en2620
            ,R.raw.en2621,R.raw.en2622,R.raw.en2623,R.raw.en2624,R.raw.en2625,R.raw.en2626,R.raw.en2627,R.raw.en2628,R.raw.en2629,R.raw.en2630
            ,R.raw.en2631,R.raw.en2632,R.raw.en2633,R.raw.en2634,R.raw.en2635,R.raw.en2636,R.raw.en2637,R.raw.en2638,R.raw.en2639,R.raw.en2640
            ,R.raw.en2641,R.raw.en2642,R.raw.en2643,R.raw.en2644,R.raw.en2645,R.raw.en2646,R.raw.en2647,R.raw.en2648,R.raw.en2649,R.raw.en2650
            ,R.raw.en2651,R.raw.en2652,R.raw.en2653,R.raw.en2654,R.raw.en2655,R.raw.en2656,R.raw.en2657,R.raw.en2658,R.raw.en2659,R.raw.en2660
            ,R.raw.en2661,R.raw.en2662,R.raw.en2663,R.raw.en2664,R.raw.en2665,R.raw.en2666,R.raw.en2667,R.raw.en2668,R.raw.en2669,R.raw.en2670
            ,R.raw.en2671,R.raw.en2672,R.raw.en2673,R.raw.en2674,R.raw.en2675,R.raw.en2676,R.raw.en2677,R.raw.en2678,R.raw.en2679,R.raw.en2680
            ,R.raw.en2681,R.raw.en2682,R.raw.en2683,R.raw.en2684,R.raw.en2685,R.raw.en2686,R.raw.en2687,R.raw.en2688,R.raw.en2689,R.raw.en2690
            ,R.raw.en2691,R.raw.en2692,R.raw.en2693,R.raw.en2694,R.raw.en2695,R.raw.en2696,R.raw.en2697,R.raw.en2698,R.raw.en2699,R.raw.en2700
            ,R.raw.en2701,R.raw.en2702,R.raw.en2703,R.raw.en2704,R.raw.en2705,R.raw.en2706,R.raw.en2707,R.raw.en2708,R.raw.en2709,R.raw.en2710
            ,R.raw.en2711,R.raw.en2712,R.raw.en2713,R.raw.en2714,R.raw.en2715,R.raw.en2716,R.raw.en2717,R.raw.en2718,R.raw.en2719,R.raw.en2720
            ,R.raw.en2721,R.raw.en2722,R.raw.en2723,R.raw.en2724,R.raw.en2725,R.raw.en2726,R.raw.en2727,R.raw.en2728,R.raw.en2729,R.raw.en2730
            ,R.raw.en2731,R.raw.en2732,R.raw.en2733,R.raw.en2734,R.raw.en2735,R.raw.en2736,R.raw.en2737,R.raw.en2738,R.raw.en2739,R.raw.en2740
            ,R.raw.en2741,R.raw.en2742,R.raw.en2743,R.raw.en2744,R.raw.en2745,R.raw.en2746,R.raw.en2747,R.raw.en2748,R.raw.en2749,R.raw.en2750
            ,R.raw.en2751,R.raw.en2752,R.raw.en2753,R.raw.en2754,R.raw.en2755,R.raw.en2756,R.raw.en2757,R.raw.en2758,R.raw.en2759,R.raw.en2760
            ,R.raw.en2761,R.raw.en2762,R.raw.en2763,R.raw.en2764,R.raw.en2765,R.raw.en2766,R.raw.en2767,R.raw.en2768,R.raw.en2769,R.raw.en2770
            ,R.raw.en2771,R.raw.en2772,R.raw.en2773,R.raw.en2774,R.raw.en2775,R.raw.en2776,R.raw.en2777,R.raw.en2778,R.raw.en2779,R.raw.en2780
            ,R.raw.en2781,R.raw.en2782,R.raw.en2783,R.raw.en2784,R.raw.en2785,R.raw.en2786,R.raw.en2787,R.raw.en2788,R.raw.en2789,R.raw.en2790
            ,R.raw.en2791,R.raw.en2792,R.raw.en2793,R.raw.en2794,R.raw.en2795,R.raw.en2796,R.raw.en2797,R.raw.en2798,R.raw.en2799,R.raw.en2800
            ,R.raw.en2801,R.raw.en2802,R.raw.en2803,R.raw.en2804,R.raw.en2805,R.raw.en2806,R.raw.en2807,R.raw.en2808,R.raw.en2809,R.raw.en2810
            ,R.raw.en2811,R.raw.en2812,R.raw.en2813,R.raw.en2814,R.raw.en2815,R.raw.en2816,R.raw.en2817,R.raw.en2818,R.raw.en2819,R.raw.en2820
            ,R.raw.en2821,R.raw.en2822,R.raw.en2823,R.raw.en2824,R.raw.en2825,R.raw.en2826,R.raw.en2827,R.raw.en2828,R.raw.en2829,R.raw.en2830
            ,R.raw.en2831,R.raw.en2832,R.raw.en2833,R.raw.en2834,R.raw.en2835,R.raw.en2836,R.raw.en2837,R.raw.en2838,R.raw.en2839,R.raw.en2840
            ,R.raw.en2841,R.raw.en2842,R.raw.en2843,R.raw.en2844,R.raw.en2845,R.raw.en2846,R.raw.en2847,R.raw.en2848,R.raw.en2849,R.raw.en2850
            ,R.raw.en2851,R.raw.en2852,R.raw.en2853,R.raw.en2854,R.raw.en2855,R.raw.en2856,R.raw.en2857,R.raw.en2858,R.raw.en2859,R.raw.en2860
            ,R.raw.en2861,R.raw.en2862,R.raw.en2863,R.raw.en2864,R.raw.en2865,R.raw.en2866,R.raw.en2867,R.raw.en2868,R.raw.en2869,R.raw.en2870
            ,R.raw.en2871,R.raw.en2872,R.raw.en2873,R.raw.en2874,R.raw.en2875,R.raw.en2876,R.raw.en2877,R.raw.en2878,R.raw.en2879,R.raw.en2880
            ,R.raw.en2881,R.raw.en2882,R.raw.en2883,R.raw.en2884,R.raw.en2885,R.raw.en2886,R.raw.en2887,R.raw.en2888,R.raw.en2889,R.raw.en2890
            ,R.raw.en2891,R.raw.en2892,R.raw.en2893,R.raw.en2894,R.raw.en2895,R.raw.en2896,R.raw.en2897,R.raw.en2898,R.raw.en2899,R.raw.en2900
            ,R.raw.en2901,R.raw.en2902,R.raw.en2903,R.raw.en2904,R.raw.en2905,R.raw.en2906,R.raw.en2907,R.raw.en2908,R.raw.en2909,R.raw.en2910
            ,R.raw.en2911,R.raw.en2912,R.raw.en2913,R.raw.en2914,R.raw.en2915,R.raw.en2916,R.raw.en2917,R.raw.en2918,R.raw.en2919,R.raw.en2920
            ,R.raw.en2921,R.raw.en2922,R.raw.en2923,R.raw.en2924,R.raw.en2925,R.raw.en2926,R.raw.en2927,R.raw.en2928,R.raw.en2929,R.raw.en2930
            ,R.raw.en2931,R.raw.en2932,R.raw.en2933,R.raw.en2934,R.raw.en2935,R.raw.en2936,R.raw.en2937,R.raw.en2938,R.raw.en2939,R.raw.en2940
            ,R.raw.en2941,R.raw.en2942,R.raw.en2943,R.raw.en2944,R.raw.en2945,R.raw.en2946,R.raw.en2947,R.raw.en2948,R.raw.en2949,R.raw.en2950
            ,R.raw.en2951,R.raw.en2952,R.raw.en2953,R.raw.en2954,R.raw.en2955,R.raw.en2956,R.raw.en2957,R.raw.en2958,R.raw.en2959,R.raw.en2960
            ,R.raw.en2961,R.raw.en2962,R.raw.en2963,R.raw.en2964,R.raw.en2965,R.raw.en2966,R.raw.en2967,R.raw.en2968,R.raw.en2969,R.raw.en2970
            ,R.raw.en2971,R.raw.en2972,R.raw.en2973,R.raw.en2974,R.raw.en2975,R.raw.en2976,R.raw.en2977,R.raw.en2978,R.raw.en2979,R.raw.en2980
            ,R.raw.en2981,R.raw.en2982,R.raw.en2983,R.raw.en2984,R.raw.en2985,R.raw.en2986,R.raw.en2987,R.raw.en2988,R.raw.en2989,R.raw.en2990
            ,R.raw.en2991,R.raw.en2992,R.raw.en2993,R.raw.en2994,R.raw.en2995,R.raw.en2996,R.raw.en2997,R.raw.en2998,R.raw.en2999,R.raw.en3000
            ,R.raw.en3001,R.raw.en3002,R.raw.en3003,R.raw.en3004,R.raw.en3005,R.raw.en3006,R.raw.en3007,R.raw.en3008,R.raw.en3009,R.raw.en3010
            ,R.raw.en3011,R.raw.en3012,R.raw.en3013,R.raw.en3014,R.raw.en3015,R.raw.en3016,R.raw.en3017,R.raw.en3018,R.raw.en3019,R.raw.en3020
            ,R.raw.en3021,R.raw.en3022,R.raw.en3023,R.raw.en3024,R.raw.en3025,R.raw.en3026,R.raw.en3027,R.raw.en3028,R.raw.en3029,R.raw.en3030
            ,R.raw.en3031,R.raw.en3032,R.raw.en3033,R.raw.en3034,R.raw.en3035,R.raw.en3036,R.raw.en3037,R.raw.en3038,R.raw.en3039,R.raw.en3040
            ,R.raw.en3041,R.raw.en3042,R.raw.en3043,R.raw.en3044,R.raw.en3045,R.raw.en3046,R.raw.en3047,R.raw.en3048,R.raw.en3049,R.raw.en3050
            ,R.raw.en3051,R.raw.en3052,R.raw.en3053,R.raw.en3054,R.raw.en3055,R.raw.en3056,R.raw.en3057,R.raw.en3058,R.raw.en3059,R.raw.en3060
            ,R.raw.en3061,R.raw.en3062,R.raw.en3063,R.raw.en3064,R.raw.en3065,R.raw.en3066,R.raw.en3067,R.raw.en3068,R.raw.en3069,R.raw.en3070
            ,R.raw.en3071,R.raw.en3072,R.raw.en3073,R.raw.en3074,R.raw.en3075,R.raw.en3076,R.raw.en3077,R.raw.en3078,R.raw.en3079,R.raw.en3080
            ,R.raw.en3081,R.raw.en3082,R.raw.en3083,R.raw.en3084,R.raw.en3085,R.raw.en3086,R.raw.en3087,R.raw.en3088,R.raw.en3089,R.raw.en3090
            ,R.raw.en3091,R.raw.en3092,R.raw.en3093,R.raw.en3094,R.raw.en3095,R.raw.en3096,R.raw.en3097,R.raw.en3098,R.raw.en3099,R.raw.en3100
            ,R.raw.en3101,R.raw.en3102,R.raw.en3103,R.raw.en3104,R.raw.en3105,R.raw.en3106,R.raw.en3107,R.raw.en3108,R.raw.en3109,R.raw.en3110
            ,R.raw.en3111,R.raw.en3112,R.raw.en3113,R.raw.en3114,R.raw.en3115,R.raw.en3116,R.raw.en3117,R.raw.en3118,R.raw.en3119,R.raw.en3120
            ,R.raw.en3121,R.raw.en3122,R.raw.en3123,R.raw.en3124,R.raw.en3125,R.raw.en3126,R.raw.en3127,R.raw.en3128,R.raw.en3129,R.raw.en3130
            ,R.raw.en3131,R.raw.en3132,R.raw.en3133,R.raw.en3134,R.raw.en3135,R.raw.en3136,R.raw.en3137,R.raw.en3138,R.raw.en3139,R.raw.en3140
            ,R.raw.en3141,R.raw.en3142,R.raw.en3143,R.raw.en3144,R.raw.en3145,R.raw.en3146,R.raw.en3147,R.raw.en3148,R.raw.en3149,R.raw.en3150
            ,R.raw.en3151,R.raw.en3152,R.raw.en3153,R.raw.en3154,R.raw.en3155,R.raw.en3156,R.raw.en3157,R.raw.en3158,R.raw.en3159,R.raw.en3160
            ,R.raw.en3161,R.raw.en3162,R.raw.en3163,R.raw.en3164,R.raw.en3165,R.raw.en3166,R.raw.en3167,R.raw.en3168,R.raw.en3169,R.raw.en3170
            ,R.raw.en3171,R.raw.en3172,R.raw.en3173,R.raw.en3174,R.raw.en3175,R.raw.en3176,R.raw.en3177,R.raw.en3178,R.raw.en3179,R.raw.en3180
            ,R.raw.en3181,R.raw.en3182,R.raw.en3183,R.raw.en3184,R.raw.en3185,R.raw.en3186,R.raw.en3187,R.raw.en3188,R.raw.en3189,R.raw.en3190
            ,R.raw.en3191,R.raw.en3192,R.raw.en3193,R.raw.en3194,R.raw.en3195,R.raw.en3196,R.raw.en3197,R.raw.en3198,R.raw.en3199,R.raw.en3200
            ,R.raw.en3201,R.raw.en3202,R.raw.en3203,R.raw.en3204,R.raw.en3205,R.raw.en3206,R.raw.en3207,R.raw.en3208,R.raw.en3209,R.raw.en3210
            ,R.raw.en3211,R.raw.en3212,R.raw.en3213,R.raw.en3214,R.raw.en3215,R.raw.en3216,R.raw.en3217,R.raw.en3218,R.raw.en3219,R.raw.en3220
            ,R.raw.en3221,R.raw.en3222,R.raw.en3223,R.raw.en3224,R.raw.en3225,R.raw.en3226,R.raw.en3227,R.raw.en3228,R.raw.en3229,R.raw.en3230
            ,R.raw.en3231,R.raw.en3232,R.raw.en3233,R.raw.en3234,R.raw.en3235,R.raw.en3236,R.raw.en3237,R.raw.en3238,R.raw.en3239,R.raw.en3240
            ,R.raw.en3241,R.raw.en3242,R.raw.en3243,R.raw.en3244,R.raw.en3245,R.raw.en3246,R.raw.en3247,R.raw.en3248,R.raw.en3249,R.raw.en3250
            ,R.raw.en3251,R.raw.en3252,R.raw.en3253,R.raw.en3254,R.raw.en3255,R.raw.en3256,R.raw.en3257,R.raw.en3258,R.raw.en3259,R.raw.en3260
            ,R.raw.en3261,R.raw.en3262,R.raw.en3263,R.raw.en3264,R.raw.en3265,R.raw.en3266,R.raw.en3267,R.raw.en3268,R.raw.en3269,R.raw.en3270
            ,R.raw.en3271,R.raw.en3272,R.raw.en3273,R.raw.en3274,R.raw.en3275,R.raw.en3276,R.raw.en3277,R.raw.en3278,R.raw.en3279,R.raw.en3280
            ,R.raw.en3281,R.raw.en3282,R.raw.en3283,R.raw.en3284,R.raw.en3285,R.raw.en3286,R.raw.en3287,R.raw.en3288,R.raw.en3289,R.raw.en3290
            ,R.raw.en3291,R.raw.en3292,R.raw.en3293,R.raw.en3294,R.raw.en3295,R.raw.en3296,R.raw.en3297,R.raw.en3298,R.raw.en3299,R.raw.en3300
            ,R.raw.en3301,R.raw.en3302,R.raw.en3303,R.raw.en3304,R.raw.en3305,R.raw.en3306,R.raw.en3307,R.raw.en3308,R.raw.en3309,R.raw.en3310
            ,R.raw.en3311,R.raw.en3312,R.raw.en3313,R.raw.en3314,R.raw.en3315,R.raw.en3316,R.raw.en3317,R.raw.en3318,R.raw.en3319,R.raw.en3320
            ,R.raw.en3321,R.raw.en3322,R.raw.en3323,R.raw.en3324,R.raw.en3325,R.raw.en3326,R.raw.en3327,R.raw.en3328,R.raw.en3329,R.raw.en3330
            ,R.raw.en3331,R.raw.en3332,R.raw.en3333,R.raw.en3334,R.raw.en3335,R.raw.en3336,R.raw.en3337,R.raw.en3338,R.raw.en3339,R.raw.en3340
            ,R.raw.en3341,R.raw.en3342,R.raw.en3343,R.raw.en3344,R.raw.en3345,R.raw.en3346,R.raw.en3347,R.raw.en3348,R.raw.en3349,R.raw.en3350
            ,R.raw.en3351,R.raw.en3352,R.raw.en3353,R.raw.en3354,R.raw.en3355,R.raw.en3356,R.raw.en3357,R.raw.en3358,R.raw.en3359,R.raw.en3360
            ,R.raw.en3361,R.raw.en3362,R.raw.en3363,R.raw.en3364,R.raw.en3365,R.raw.en3366,R.raw.en3367,R.raw.en3368,R.raw.en3369,R.raw.en3370
            ,R.raw.en3371,R.raw.en3372,R.raw.en3373,R.raw.en3374,R.raw.en3375,R.raw.en3376,R.raw.en3377,R.raw.en3378,R.raw.en3379,R.raw.en3380
            ,R.raw.en3381,R.raw.en3382,R.raw.en3383,R.raw.en3384,R.raw.en3385,R.raw.en3386,R.raw.en3387,R.raw.en3388,R.raw.en3389,R.raw.en3390
            ,R.raw.en3391,R.raw.en3392,R.raw.en3393,R.raw.en3394,R.raw.en3395,R.raw.en3396,R.raw.en3397,R.raw.en3398,R.raw.en3399,R.raw.en3400
            ,R.raw.en3401,R.raw.en3402,R.raw.en3403,R.raw.en3404,R.raw.en3405,R.raw.en3406,R.raw.en3407,R.raw.en3408,R.raw.en3409,R.raw.en3410
            ,R.raw.en3411,R.raw.en3412,R.raw.en3413,R.raw.en3414,R.raw.en3415,R.raw.en3416,R.raw.en3417,R.raw.en3418,R.raw.en3419,R.raw.en3420
            ,R.raw.en3421,R.raw.en3422,R.raw.en3423,R.raw.en3424,R.raw.en3425,R.raw.en3426,R.raw.en3427,R.raw.en3428,R.raw.en3429,R.raw.en3430
            ,R.raw.en3431,R.raw.en3432,R.raw.en3433,R.raw.en3434,R.raw.en3435,R.raw.en3436,R.raw.en3437,R.raw.en3438,R.raw.en3439,R.raw.en3440
            ,R.raw.en3441,R.raw.en3442,R.raw.en3443,R.raw.en3444,R.raw.en3445,R.raw.en3446,R.raw.en3447,R.raw.en3448,R.raw.en3449,R.raw.en3450
            ,R.raw.en3451,R.raw.en3452,R.raw.en3453,R.raw.en3454,R.raw.en3455,R.raw.en3456,R.raw.en3457,R.raw.en3458,R.raw.en3459,R.raw.en3460
            ,R.raw.en3461,R.raw.en3462,R.raw.en3463,R.raw.en3464,R.raw.en3465,R.raw.en3466,R.raw.en3467,R.raw.en3468,R.raw.en3469,R.raw.en3470
            ,R.raw.en3471,R.raw.en3472,R.raw.en3473,R.raw.en3474,R.raw.en3475,R.raw.en3476,R.raw.en3477,R.raw.en3478,R.raw.en3479,R.raw.en3480
            ,R.raw.en3481,R.raw.en3482,R.raw.en3483,R.raw.en3484,R.raw.en3485,R.raw.en3486,R.raw.en3487,R.raw.en3488,R.raw.en3489,R.raw.en3490
            ,R.raw.en3491,R.raw.en3492,R.raw.en3493,R.raw.en3494,R.raw.en3495,R.raw.en3496,R.raw.en3497,R.raw.en3498,R.raw.en3499,R.raw.en3500
            ,R.raw.en3501,R.raw.en3502,R.raw.en3503,R.raw.en3504,R.raw.en3505,R.raw.en3506,R.raw.en3507,R.raw.en3508,R.raw.en3509,R.raw.en3510
            ,R.raw.en3511,R.raw.en3512,R.raw.en3513,R.raw.en3514,R.raw.en3515,R.raw.en3516,R.raw.en3517,R.raw.en3518,R.raw.en3519,R.raw.en3520
            ,R.raw.en3521,R.raw.en3522,R.raw.en3523,R.raw.en3524,R.raw.en3525,R.raw.en3526,R.raw.en3527,R.raw.en3528,R.raw.en3529,R.raw.en3530
            ,R.raw.en3531,R.raw.en3532,R.raw.en3533,R.raw.en3534,R.raw.en3535,R.raw.en3536,R.raw.en3537,R.raw.en3538,R.raw.en3539,R.raw.en3540
            ,R.raw.en3541,R.raw.en3542,R.raw.en3543,R.raw.en3544,R.raw.en3545,R.raw.en3546,R.raw.en3547,R.raw.en3548,R.raw.en3549,R.raw.en3550
            ,R.raw.en3551,R.raw.en3552,R.raw.en3553,R.raw.en3554,R.raw.en3555,R.raw.en3556,R.raw.en3557,R.raw.en3558,R.raw.en3559,R.raw.en3560
            ,R.raw.en3561,R.raw.en3562,R.raw.en3563,R.raw.en3564,R.raw.en3565,R.raw.en3566,R.raw.en3567,R.raw.en3568,R.raw.en3569,R.raw.en3570
            ,R.raw.en3571,R.raw.en3572,R.raw.en3573,R.raw.en3574,R.raw.en3575,R.raw.en3576,R.raw.en3577,R.raw.en3578,R.raw.en3579,R.raw.en3580
            ,R.raw.en3581,R.raw.en3582,R.raw.en3583,R.raw.en3584,R.raw.en3585,R.raw.en3586,R.raw.en3587,R.raw.en3588,R.raw.en3589,R.raw.en3590
            ,R.raw.en3591,R.raw.en3592,R.raw.en3593,R.raw.en3594,R.raw.en3595,R.raw.en3596,R.raw.en3597,R.raw.en3598,R.raw.en3599,R.raw.en3600
            ,R.raw.en3601,R.raw.en3602,R.raw.en3603,R.raw.en3604,R.raw.en3605,R.raw.en3606,R.raw.en3607,R.raw.en3608,R.raw.en3609,R.raw.en3610
            ,R.raw.en3611,R.raw.en3612,R.raw.en3613,R.raw.en3614,R.raw.en3615,R.raw.en3616,R.raw.en3617,R.raw.en3618,R.raw.en3619,R.raw.en3620
            ,R.raw.en3621,R.raw.en3622,R.raw.en3623,R.raw.en3624,R.raw.en3625,R.raw.en3626,R.raw.en3627,R.raw.en3628,R.raw.en3629,R.raw.en3630
            ,R.raw.en3631,R.raw.en3632,R.raw.en3633,R.raw.en3634,R.raw.en3635,R.raw.en3636,R.raw.en3637,R.raw.en3638,R.raw.en3639,R.raw.en3640
            ,R.raw.en3641,R.raw.en3642,R.raw.en3643,R.raw.en3644,R.raw.en3645,R.raw.en3646,R.raw.en3647,R.raw.en3648,R.raw.en3649,R.raw.en3650
            ,R.raw.en3651,R.raw.en3652,R.raw.en3653,R.raw.en3654,R.raw.en3655,R.raw.en3656,R.raw.en3657,R.raw.en3658,R.raw.en3659,R.raw.en3660
            ,R.raw.en3661,R.raw.en3662,R.raw.en3663,R.raw.en3664,R.raw.en3665,R.raw.en3666,R.raw.en3667,R.raw.en3668,R.raw.en3669,R.raw.en3670
            ,R.raw.en3671,R.raw.en3672,R.raw.en3673,R.raw.en3674,R.raw.en3675,R.raw.en3676,R.raw.en3677,R.raw.en3678,R.raw.en3679,R.raw.en3680
            ,R.raw.en3681,R.raw.en3682,R.raw.en3683,R.raw.en3684,R.raw.en3685,R.raw.en3686,R.raw.en3687,R.raw.en3688,R.raw.en3689,R.raw.en3690
            ,R.raw.en3691,R.raw.en3692,R.raw.en3693,R.raw.en3694,R.raw.en3695,R.raw.en3696,R.raw.en3697,R.raw.en3698,R.raw.en3699,R.raw.en3700
            ,R.raw.en3701,R.raw.en3702,R.raw.en3703,R.raw.en3704,R.raw.en3705,R.raw.en3706,R.raw.en3707,R.raw.en3708,R.raw.en3709,R.raw.en3710
            ,R.raw.en3711,R.raw.en3712,R.raw.en3713,R.raw.en3714,R.raw.en3715,R.raw.en3716,R.raw.en3717,R.raw.en3718,R.raw.en3719,R.raw.en3720
            ,R.raw.en3721,R.raw.en3722,R.raw.en3723,R.raw.en3724,R.raw.en3725,R.raw.en3726,R.raw.en3727,R.raw.en3728,R.raw.en3729,R.raw.en3730
            ,R.raw.en3731,R.raw.en3732,R.raw.en3733,R.raw.en3734,R.raw.en3735,R.raw.en3736,R.raw.en3737,R.raw.en3738,R.raw.en3739,R.raw.en3740
            ,R.raw.en3741,R.raw.en3742,R.raw.en3743,R.raw.en3744,R.raw.en3745,R.raw.en3746,R.raw.en3747,R.raw.en3748,R.raw.en3749,R.raw.en3750
            ,R.raw.en3751,R.raw.en3752,R.raw.en3753,R.raw.en3754,R.raw.en3755,R.raw.en3756,R.raw.en3757,R.raw.en3758,R.raw.en3759,R.raw.en3760
            ,R.raw.en3761,R.raw.en3762,R.raw.en3763,R.raw.en3764,R.raw.en3765,R.raw.en3766,R.raw.en3767,R.raw.en3768,R.raw.en3769,R.raw.en3770
            ,R.raw.en3771,R.raw.en3772,R.raw.en3773,R.raw.en3774,R.raw.en3775,R.raw.en3776,R.raw.en3777,R.raw.en3778,R.raw.en3779,R.raw.en3780
            ,R.raw.en3781,R.raw.en3782,R.raw.en3783,R.raw.en3784,R.raw.en3785,R.raw.en3786,R.raw.en3787,R.raw.en3788,R.raw.en3789,R.raw.en3790
            ,R.raw.en3791,R.raw.en3792,R.raw.en3793,R.raw.en3794,R.raw.en3795,R.raw.en3796,R.raw.en3797,R.raw.en3798,R.raw.en3799,R.raw.en3800
            ,R.raw.en3801,R.raw.en3802,R.raw.en3803,R.raw.en3804,R.raw.en3805,R.raw.en3806,R.raw.en3807,R.raw.en3808,R.raw.en3809,R.raw.en3810
            ,R.raw.en3811,R.raw.en3812,R.raw.en3813,R.raw.en3814,R.raw.en3815,R.raw.en3816,R.raw.en3817,R.raw.en3818,R.raw.en3819,R.raw.en3820
            ,R.raw.en3821,R.raw.en3822,R.raw.en3823,R.raw.en3824,R.raw.en3825,R.raw.en3826,R.raw.en3827,R.raw.en3828,R.raw.en3829,R.raw.en3830
            ,R.raw.en3831,R.raw.en3832,R.raw.en3833,R.raw.en3834,R.raw.en3835,R.raw.en3836,R.raw.en3837,R.raw.en3838,R.raw.en3839,R.raw.en3840
            ,R.raw.en3841,R.raw.en3842,R.raw.en3843,R.raw.en3844,R.raw.en3845,R.raw.en3846,R.raw.en3847,R.raw.en3848,R.raw.en3849,R.raw.en3850
            ,R.raw.en3851,R.raw.en3852,R.raw.en3853,R.raw.en3854,R.raw.en3855,R.raw.en3856,R.raw.en3857,R.raw.en3858,R.raw.en3859,R.raw.en3860
            ,R.raw.en3861,R.raw.en3862,R.raw.en3863,R.raw.en3864,R.raw.en3865,R.raw.en3866,R.raw.en3867,R.raw.en3868,R.raw.en3869,R.raw.en3870
            ,R.raw.en3871,R.raw.en3872,R.raw.en3873,R.raw.en3874,R.raw.en3875,R.raw.en3876,R.raw.en3877,R.raw.en3878,R.raw.en3879,R.raw.en3880
            ,R.raw.en3881,R.raw.en3882,R.raw.en3883,R.raw.en3884,R.raw.en3885,R.raw.en3886,R.raw.en3887,R.raw.en3888,R.raw.en3889,R.raw.en3890
            ,R.raw.en3891,R.raw.en3892,R.raw.en3893,R.raw.en3894,R.raw.en3895,R.raw.en3896,R.raw.en3897,R.raw.en3898,R.raw.en3899,R.raw.en3900
            ,R.raw.en3901,R.raw.en3902,R.raw.en3903,R.raw.en3904,R.raw.en3905,R.raw.en3906,R.raw.en3907,R.raw.en3908,R.raw.en3909,R.raw.en3910
            ,R.raw.en3911,R.raw.en3912,R.raw.en3913,R.raw.en3914,R.raw.en3915,R.raw.en3916,R.raw.en3917,R.raw.en3918,R.raw.en3919,R.raw.en3920
            ,R.raw.en3921,R.raw.en3922,R.raw.en3923,R.raw.en3924,R.raw.en3925,R.raw.en3926,R.raw.en3927,R.raw.en3928,R.raw.en3929,R.raw.en3930
            ,R.raw.en3931,R.raw.en3932,R.raw.en3933,R.raw.en3934,R.raw.en3935,R.raw.en3936,R.raw.en3937,R.raw.en3938,R.raw.en3939,R.raw.en3940
            ,R.raw.en3941,R.raw.en3942,R.raw.en3943,R.raw.en3944,R.raw.en3945,R.raw.en3946,R.raw.en3947,R.raw.en3948,R.raw.en3949,R.raw.en3950
            ,R.raw.en3951,R.raw.en3952,R.raw.en3953,R.raw.en3954,R.raw.en3955,R.raw.en3956,R.raw.en3957,R.raw.en3958,R.raw.en3959,R.raw.en3960
            ,R.raw.en3961,R.raw.en3962,R.raw.en3963,R.raw.en3964,R.raw.en3965,R.raw.en3966,R.raw.en3967,R.raw.en3968,R.raw.en3969,R.raw.en3970
            ,R.raw.en3971,R.raw.en3972,R.raw.en3973,R.raw.en3974,R.raw.en3975,R.raw.en3976,R.raw.en3977,R.raw.en3978,R.raw.en3979,R.raw.en3980
            ,R.raw.en3981,R.raw.en3982,R.raw.en3983,R.raw.en3984,R.raw.en3985,R.raw.en3986,R.raw.en3987,R.raw.en3988,R.raw.en3989,R.raw.en3990
            ,R.raw.en3991,R.raw.en3992,R.raw.en3993,R.raw.en3994,R.raw.en3995,R.raw.en3996,R.raw.en3997,R.raw.en3998,R.raw.en3999,R.raw.en4000
            ,R.raw.en4001,R.raw.en4002,R.raw.en4003,R.raw.en4004,R.raw.en4005,R.raw.en4006,R.raw.en4007,R.raw.en4008,R.raw.en4009,R.raw.en4010
            ,R.raw.en4011,R.raw.en4012,R.raw.en4013,R.raw.en4014,R.raw.en4015,R.raw.en4016,R.raw.en4017,R.raw.en4018,R.raw.en4019,R.raw.en4020
            ,R.raw.en4021,R.raw.en4022,R.raw.en4023,R.raw.en4024,R.raw.en4025,R.raw.en4026,R.raw.en4027,R.raw.en4028,R.raw.en4029,R.raw.en4030
            ,R.raw.en4031,R.raw.en4032,R.raw.en4033,R.raw.en4034,R.raw.en4035,R.raw.en4036,R.raw.en4037,R.raw.en4038,R.raw.en4039,R.raw.en4040
            ,R.raw.en4041,R.raw.en4042,R.raw.en4043,R.raw.en4044,R.raw.en4045,R.raw.en4046,R.raw.en4047,R.raw.en4048,R.raw.en4049,R.raw.en4050
            ,R.raw.en4051,R.raw.en4052,R.raw.en4053,R.raw.en4054,R.raw.en4055,R.raw.en4056,R.raw.en4057,R.raw.en4058,R.raw.en4059,R.raw.en4060
            ,R.raw.en4061,R.raw.en4062,R.raw.en4063,R.raw.en4064,R.raw.en4065,R.raw.en4066,R.raw.en4067,R.raw.en4068,R.raw.en4069,R.raw.en4070
            ,R.raw.en4071,R.raw.en4072,R.raw.en4073,R.raw.en4074,R.raw.en4075,R.raw.en4076,R.raw.en4077,R.raw.en4078,R.raw.en4079,R.raw.en4080
            ,R.raw.en4081,R.raw.en4082,R.raw.en4083,R.raw.en4084,R.raw.en4085,R.raw.en4086,R.raw.en4087,R.raw.en4088,R.raw.en4089,R.raw.en4090
            ,R.raw.en4091,R.raw.en4092,R.raw.en4093,R.raw.en4094,R.raw.en4095,R.raw.en4096,R.raw.en4097,R.raw.en4098,R.raw.en4099,R.raw.en4100
            ,R.raw.en4101,R.raw.en4102};

             MediaPlayer mMediaTH;
             MediaPlayer mMediaEN;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);
        lvocabulary = (ListView)findViewById(R.id.showThai);
        lvocabulary1 = (ListView)findViewById(R.id.showEng);
        mDBHelper = new DatabaseHalper(this);
        Intent intent = this.getIntent();
        final String ID = intent.getStringExtra("ID");
        final int id = intent.getExtras().getInt("id");
        final int i = Integer.parseInt(ID);


        Button btn1 = (Button) findViewById(R.id.back);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent1);
                finish();
            }
        });

        soundth = (ImageView) findViewById(R.id.imageButton);
        soundth.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMediaTH = MediaPlayer.create(detailactivity2.this,soundfileTH[id]);
                mMediaTH.start();
            }
        });

        sounden = (ImageView) findViewById(R.id.imageButton2);
        sounden.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mMediaEN = MediaPlayer.create(detailactivity2.this,soundfileEN[id]);
                mMediaEN.start();
            }
        });

        mVocabularyList = mDBHelper.showdetail(i);
        adapter = new ShowVocabularyAdapter(this,mVocabularyList);
        adapter1 = new ShowEng(this,mVocabularyList);
        lvocabulary.setAdapter(adapter);
        lvocabulary1.setAdapter(adapter1);
        File database = getApplicationContext().getDatabasePath(DatabaseHalper.DBNAME);
        if(false == database.exists()){
            mDBHelper.getReadableDatabase();
            if(coppyDatabase(this)){
                Toast.makeText(this, "Coppy Database Succes",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Coppy Data Errer", Toast.LENGTH_SHORT).show();
                return;
            }
        }

    }
    public boolean coppyDatabase(Context context){
        try{
            InputStream inputStream = context.getAssets().open(DatabaseHalper.DBNAME);
            String outFileName = DatabaseHalper.DBLOCATION + DatabaseHalper.DBNAME;
            OutputStream outputStream = new FileOutputStream(outFileName);
            byte[] buff = new byte[1024];
            int length = 0;
            while((length = inputStream.read(buff))>0){
                outputStream.write(buff, 0, length);
            }
            outputStream.flush();
            outputStream.close();
            Log.v("detailactivity2","DB copied");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
