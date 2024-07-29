package com.rockstargames.gtacr.gui.drivingSchool;

import android.text.SpannableString;
import blackrussia.online.R;
import com.rockstargames.gtacr.data.SignObj;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;

//@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/Utils;", "", "()V", "CATEGORY_A", "", "CATEGORY_B", "CATEGORY_C", "CATEGORY_D", "CATEGORY_SHIP", "CLASS_INFO_LAYOUT", "MAIN_LAYOUT", "QUESTIONS_LAYOUT", "radialMenuInfoCategoriesABCD", "", "Lcom/rockstargames/gtacr/data/SignObj;", "getRadialMenuInfoCategoriesABCD", "()Ljava/util/List;", "radialMenuInfoCategoriesShip", "getRadialMenuInfoCategoriesShip", "roadSignsCategoriesAB", "getRoadSignsCategoriesAB", "roadSignsCategoriesC", "getRoadSignsCategoriesC", "roadSignsCategoriesD", "getRoadSignsCategoriesD", "roadSignsCategoriesShip", "getRoadSignsCategoriesShip", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Utils {
    public static final int CATEGORY_A = 0;
    public static final int CATEGORY_B = 1;
    public static final int CATEGORY_C = 2;
    public static final int CATEGORY_D = 3;
    public static final int CATEGORY_SHIP = 4;
    public static final int CLASS_INFO_LAYOUT = 2;
    public static final Utils INSTANCE = new Utils();
    public static final int MAIN_LAYOUT = 1;
    public static final int QUESTIONS_LAYOUT = 3;
    private static final List<SignObj> radialMenuInfoCategoriesABCD;
    private static final List<SignObj> radialMenuInfoCategoriesShip;
    private static final List<SignObj> roadSignsCategoriesAB;
    private static final List<SignObj> roadSignsCategoriesC;
    private static final List<SignObj> roadSignsCategoriesD;
    private static final List<SignObj> roadSignsCategoriesShip;

    private Utils() {
    }

    static {
        ArrayList arrayList = new ArrayList();
        SpannableString spannableString = new SpannableString("Знак «Главная дорога»");
        SpannableString spannableString2 = new SpannableString("Знак «Въезд запрещен»");
        Integer valueOf = Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_entry_res);
        arrayList.add(new SignObj(null, spannableString, 5, "Водитель, на дороге которого установлен этот знак двигается по главной дороге и не обязан пропускать транспортные средства. Действует 1 перекресток.", R.drawable.driving_school_icon_sign_main_road_res, null, spannableString2, 5, Answers.QUESTION_12_ANSWER_2, valueOf, true, 33, null));
        SpannableString spannableString3 = new SpannableString("Знак «Движение запрещено»");
        SpannableString spannableString4 = new SpannableString("Знак «Движение без остановки запрещено»");
        Integer valueOf2 = Integer.valueOf((int) R.drawable.driving_school_icon_sign_stop_res);
        arrayList.add(new SignObj(null, spannableString3, 5, "Этот знак запрещает движение всех транспортных средств, за исключением автомобилей предприятия, обслуживающего данную зону (Дальнобойщиков) и маршруртные автомобили.", R.drawable.driving_school_icon_sign_no_drive_res, null, spannableString4, 5, "Данный знак призывает водителя остановить свое  транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", valueOf2, true, 33, null));
        SpannableString spannableString5 = new SpannableString("Знак «Контроль»");
        SpannableString spannableString6 = new SpannableString("Знак «Ограничение макс. скорости»");
        Integer valueOf3 = Integer.valueOf((int) R.drawable.driving_school_icon_sign_max_speed_res);
        arrayList.add(new SignObj(null, spannableString5, 5, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", R.drawable.driving_school_icon_sign_control_res, null, spannableString6, 5, Answers.QUESTION_17_ANSWER_4, valueOf3, true, 33, null));
        SpannableString spannableString7 = new SpannableString("Знак «Ограничение высоты»");
        SpannableString spannableString8 = new SpannableString("Знак «Обгон запрещен»");
        Integer valueOf4 = Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_overtaking_res);
        arrayList.add(new SignObj(null, spannableString7, 5, Answers.QUESTION_14_ANSWER_1, R.drawable.driving_school_icon_sign_max_hight_res, null, spannableString8, 5, "Этот знак запрещает обгон всех транспортных средств, движущихся по участку, на котором установлен этот знак.", valueOf4, true, 33, null));
        SpannableString spannableString9 = new SpannableString("Знак «Конец зоны всех ограничений»");
        SpannableString spannableString10 = new SpannableString("Знак «Круговое движение»");
        Integer valueOf5 = Integer.valueOf((int) R.drawable.driving_school_icon_sign_ring_drive_res);
        arrayList.add(new SignObj(null, spannableString9, 5, Answers.QUESTION_18_ANSWER_4, R.drawable.driving_school_icon_sign_no_limitation_res, null, spannableString10, 5, Answers.QUESTION_19_ANSWER_1, valueOf5, true, 33, null));
        SpannableString spannableString11 = new SpannableString("Знак «Автомагистраль»");
        SpannableString spannableString12 = new SpannableString("Знак «Парковка»");
        Integer valueOf6 = Integer.valueOf((int) R.drawable.driving_school_icon_sign_parking_res);
        arrayList.add(new SignObj(null, spannableString11, 5, "Наиболее скоростная дорога. Минимальная скорость на данной дороге 40 км/ч, максимальная - 110 км/ч. Остановка внеспециальных стоянок запрещена.", R.drawable.driving_school_icon_sign_motorway_res, null, spannableString12, 5, "Знак обозначает специализированную площадку для остановки транспортных средств.", valueOf6, true, 33, null));
        SpannableString spannableString13 = new SpannableString("Знак «Зона с ограничением максимальной скорости»");
        SpannableString spannableString14 = new SpannableString("Знак «Автобусная остановка»");
        Integer valueOf7 = Integer.valueOf((int) R.drawable.driving_school_icon_sign_bus_stop_res);
        arrayList.add(new SignObj(null, spannableString13, 5, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака «Конец зоны с ограничением максимальной скорости».", R.drawable.driving_school_icon_sign_zone_max_speed_res, null, spannableString14, 5, Answers.QUESTION_21_ANSWER_1, valueOf7, true, 33, null));
        arrayList.add(new SignObj(null, new SpannableString("Знак «Пешеходный переход»"), 5, "Знак обозначает специализированный наземный пешеходный переход, на котором водитель обязан уступить дорогу пешеходу.", R.drawable.driving_school_icon_sign_crosswalk_res, null, new SpannableString("Знак «Населенный пункт»"), 5, "Знак обозначает начало населенного пункта. После этого знака ограничение скорости - 60км/ч (Максимальная скорость в населенных пунктах).", Integer.valueOf((int) R.drawable.driving_school_icon_sign_start_city_res), true, 33, null));
        arrayList.add(new SignObj(null, new SpannableString("Знак «Конец населенного пункта»"), 5, "Знак обозначает конец населенного пункта. После этого знака ограничение скорости - 90км/ч (Максимальная скорость вне населенных пунктов).", R.drawable.driving_school_icon_sign_end_city_res, null, new SpannableString("Знак «Уступите дорогу»"), 5, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа).", Integer.valueOf((int) R.drawable.driving_school_icon_sign_give_way_res), true, 33, null));
        arrayList.add(new SignObj(null, new SpannableString("Знак «Остановка запрещена»"), 5, "Данный знак запрещает остановку и стоянку транспортных средств. Распространяется только на одну сторону дороги.", R.drawable.driving_school_icon_sign_no_stop_res, null, new SpannableString("Знак «Стоянка запрещена»"), 5, "Данный знак запрещает стоянку транспортных средств. Распространяется только на одну сторону дороги.", Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_parking_res), true, 33, null));
        arrayList.add(new SignObj(null, new SpannableString("Знак «Движение прямо»"), 5, "Данный знак разрешает только движение прямо. Аналогичные знаки с движением направо, налево, разворотом и другими знаками.", R.drawable.driving_school_icon_sign_straight_ahead_res, null, new SpannableString("Знак «Поворот направо запрещен»"), 5, Answers.QUESTION_31_ANSWER_2, Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_turn_res), true, 33, null));
        arrayList.add(new SignObj(null, new SpannableString("Знак «Фотовидеофиксация»"), 5, Answers.QUESTION_32_ANSWER_2, R.drawable.driving_school_icon_sign_photo_control_res, null, null, null, null, null, false, 33, null));
        Unit unit = Unit.INSTANCE;
        roadSignsCategoriesAB = arrayList;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Главная дорога»"), 5, "Водитель, на дороге которого установлен этот знак двигается по главной дороге и не обязан пропускать транспортные средства. Действует 1 перекресток.", R.drawable.driving_school_icon_sign_main_road_res, null, new SpannableString("Знак «Въезд запрещен»"), 5, Answers.QUESTION_12_ANSWER_2, valueOf, true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Движение запрещено»"), 5, "Этот знак запрещает движение всех транспортных средств, за исключением автомобилей предприятия, обслуживающего данную зону (Дальнобойщиков) и маршруртные автомобили.", R.drawable.driving_school_icon_sign_no_drive_res, null, new SpannableString("Знак «Движение без остановки запрещено»"), 5, "Данный знак призывает водителя остановить свое  транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", valueOf2, true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Контроль»"), 5, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", R.drawable.driving_school_icon_sign_control_res, null, new SpannableString("Знак «Ограничение макс. скорости»"), 5, Answers.QUESTION_17_ANSWER_4, valueOf3, true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Ограничение высоты»"), 5, Answers.QUESTION_14_ANSWER_1, R.drawable.driving_school_icon_sign_max_hight_res, null, new SpannableString("Знак «Обгон запрещен»"), 5, "Этот знак запрещает обгон всех транспортных средств, движущихся по участку, на котором установлен этот знак.", valueOf4, true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Конец зоны всех ограничений»"), 5, Answers.QUESTION_18_ANSWER_4, R.drawable.driving_school_icon_sign_no_limitation_res, null, new SpannableString("Знак «Круговое движение»"), 5, Answers.QUESTION_19_ANSWER_1, valueOf5, true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Автомагистраль»"), 5, "Наиболее скоростная дорога. Минимальная скорость на данной дороге 40 км/ч, максимальная - 110 км/ч. Остановка внеспециальных стоянок запрещена.", R.drawable.driving_school_icon_sign_motorway_res, null, new SpannableString("Знак «Парковка»"), 5, "Знак обозначает специализированную площадку для остановки транспортных средств.", valueOf6, true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Зона с ограничением максимальной скорости»"), 5, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака «Конец зоны с ограничением максимальной скорости».", R.drawable.driving_school_icon_sign_zone_max_speed_res, null, new SpannableString("Знак «Автобусная остановка»"), 5, Answers.QUESTION_21_ANSWER_1, valueOf7, true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Пешеходный переход»"), 5, "Знак обозначает специализированный наземный пешеходный переход, на котором водитель обязан уступить дорогу пешеходу.", R.drawable.driving_school_icon_sign_crosswalk_res, null, new SpannableString("Знак «Населенный пункт»"), 5, "Знак обозначает начало населенного пункта. После этого знака ограничение скорости - 60км/ч (Максимальная скорость в населенных пунктах).", Integer.valueOf((int) R.drawable.driving_school_icon_sign_start_city_res), true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Конец населенного пункта»"), 5, "Знак обозначает конец населенного пункта. После этого знака ограничение скорости - 90км/ч (Максимальная скорость вне населенных пунктов).", R.drawable.driving_school_icon_sign_end_city_res, null, new SpannableString("Знак «Уступите дорогу»"), 5, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа).", Integer.valueOf((int) R.drawable.driving_school_icon_sign_give_way_res), true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Остановка запрещена»"), 5, "Данный знак запрещает остановку и стоянку транспортных средств. Распространяется только на одну сторону дороги.", R.drawable.driving_school_icon_sign_no_stop_res, null, new SpannableString("Знак «Стоянка запрещена»"), 5, "Данный знак запрещает стоянку транспортных средств. Распространяется только на одну сторону дороги.", Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_parking_res), true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Движение прямо»"), 5, "Данный знак разрешает только движение прямо. Аналогичные знаки с движением направо, налево, разворотом и другими знаками.", R.drawable.driving_school_icon_sign_straight_ahead_res, null, new SpannableString("Знак «Поворот направо запрещен»"), 5, Answers.QUESTION_31_ANSWER_2, Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_turn_res), true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Фотовидеофиксация»"), 5, Answers.QUESTION_32_ANSWER_2, R.drawable.driving_school_icon_sign_photo_control_res, null, new SpannableString("Знак «Направление движения для грузовых авто»"), 5, "Данный знак информирует о направлении движения для грузовых автомобилей.", Integer.valueOf((int) R.drawable.driving_school_icon_way_for_cargo_car_res), true, 33, null));
        arrayList2.add(new SignObj(null, new SpannableString("Знак «Обгон грузовыми автомобилем запрещен»"), 5, Answers.QUESTION_34_ANSWER_1, R.drawable.driving_school_icon_sign_no_overtaking_cargo_car_res, null, new SpannableString("Знак «Движение грузовых автомобилей»"), 5, Answers.QUESTION_35_ANSWER_4, Integer.valueOf((int) R.drawable.driving_school_icon_no_driving_cargo_trunk_res), false, 33, null));
        Unit unit2 = Unit.INSTANCE;
        roadSignsCategoriesC = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Главная дорога»"), 5, "Водитель, на дороге которого установлен этот знак двигается по главной дороге и не обязан пропускать транспортные средства. Действует 1 перекресток.", R.drawable.driving_school_icon_sign_main_road_res, null, new SpannableString("Знак «Въезд запрещен»"), 5, Answers.QUESTION_12_ANSWER_2, valueOf, true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Движение запрещено»"), 5, "Этот знак запрещает движение всех транспортных средств, за исключением автомобилей предприятия, обслуживающего данную зону (Дальнобойщиков) и маршруртные автомобили.", R.drawable.driving_school_icon_sign_no_drive_res, null, new SpannableString("Знак «Движение без остановки запрещено»"), 5, "Данный знак призывает водителя остановить свое  транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", valueOf2, true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Контроль»"), 5, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", R.drawable.driving_school_icon_sign_control_res, null, new SpannableString("Знак «Ограничение макс. скорости»"), 5, Answers.QUESTION_17_ANSWER_4, valueOf3, true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Ограничение высоты»"), 5, Answers.QUESTION_14_ANSWER_1, R.drawable.driving_school_icon_sign_max_hight_res, null, new SpannableString("Знак «Обгон запрещен»"), 5, "Этот знак запрещает обгон всех транспортных средств, движущихся по участку, на котором установлен этот знак.", valueOf4, true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Конец зоны всех ограничений»"), 5, Answers.QUESTION_18_ANSWER_4, R.drawable.driving_school_icon_sign_no_limitation_res, null, new SpannableString("Знак «Круговое движение»"), 5, Answers.QUESTION_19_ANSWER_1, valueOf5, true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Автомагистраль»"), 5, "Наиболее скоростная дорога. Минимальная скорость на данной дороге 40 км/ч, максимальная - 110 км/ч. Остановка внеспециальных стоянок запрещена.", R.drawable.driving_school_icon_sign_motorway_res, null, new SpannableString("Знак «Парковка»"), 5, "Знак обозначает специализированную площадку для остановки транспортных средств.", valueOf6, true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Зона с ограничением максимальной скорости»"), 5, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака «Конец зоны с ограничением максимальной скорости».", R.drawable.driving_school_icon_sign_zone_max_speed_res, null, new SpannableString("Знак «Автобусная остановка»"), 5, Answers.QUESTION_21_ANSWER_1, valueOf7, true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Пешеходный переход»"), 5, "Знак обозначает специализированный наземный пешеходный переход, на котором водитель обязан уступить дорогу пешеходу.", R.drawable.driving_school_icon_sign_crosswalk_res, null, new SpannableString("Знак «Населенный пункт»"), 5, "Знак обозначает начало населенного пункта. После этого знака ограничение скорости - 60км/ч (Максимальная скорость в населенных пунктах).", Integer.valueOf((int) R.drawable.driving_school_icon_sign_start_city_res), true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Конец населенного пункта»"), 5, "Знак обозначает конец населенного пункта. После этого знака ограничение скорости - 90км/ч (Максимальная скорость вне населенных пунктов).", R.drawable.driving_school_icon_sign_end_city_res, null, new SpannableString("Знак «Уступите дорогу»"), 5, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа).", Integer.valueOf((int) R.drawable.driving_school_icon_sign_give_way_res), true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Остановка запрещена»"), 5, "Данный знак запрещает остановку и стоянку транспортных средств. Распространяется только на одну сторону дороги.", R.drawable.driving_school_icon_sign_no_stop_res, null, new SpannableString("Знак «Стоянка запрещена»"), 5, "Данный знак запрещает стоянку транспортных средств. Распространяется только на одну сторону дороги.", Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_parking_res), true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Движение прямо»"), 5, "Данный знак разрешает только движение прямо. Аналогичные знаки с движением направо, налево, разворотом и другими знаками.", R.drawable.driving_school_icon_sign_straight_ahead_res, null, new SpannableString("Знак «Поворот направо запрещен»"), 5, Answers.QUESTION_31_ANSWER_2, Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_turn_res), true, 33, null));
        arrayList3.add(new SignObj(null, new SpannableString("Знак «Фотовидеофиксация»"), 5, Answers.QUESTION_32_ANSWER_2, R.drawable.driving_school_icon_sign_photo_control_res, null, new SpannableString("Знак «Автобусная полоса»"), 5, Answers.QUESTION_36_ANSWER_1, Integer.valueOf((int) R.drawable.driving_school_icon_bus_road_res), false, 33, null));
        Unit unit3 = Unit.INSTANCE;
        roadSignsCategoriesD = arrayList3;
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new SignObj(null, new SpannableString("Знак «Якоря не бросать»"), 5, "Данный знак запрещает вставать на якорь на участке, где он установлен.", R.drawable.driving_school_icon_sign_no_drop_anchor_res, null, new SpannableString("Знак «Не создавать волнения»"), 5, "Данный знак запрещает создавать волнение на участке, где он установлен.", Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_make_waves_res), true, 33, null));
        arrayList4.add(new SignObj(null, new SpannableString("Знак «Движение мелких плавсредств запрещено»"), 5, "Данный знак запрещает движение мелких плавательных средств на участке, где он установлен.", R.drawable.driving_school_icon_sign_stop_ship_res, null, new SpannableString("Знак «Стоянка и швартовка запрещены»"), 5, "Данный знак запрещает парковку, швартовку и остановку на участке, где он установлен.", Integer.valueOf((int) R.drawable.driving_school_icon_sign_no_parking_ship_res), false, 33, null));
        Unit unit4 = Unit.INSTANCE;
        roadSignsCategoriesShip = arrayList4;
        ArrayList arrayList5 = new ArrayList();
        arrayList5.add(new SignObj(1, new SpannableString("Включить или выключить двигатель"), 23, "Если поле горит зеленым — двигатель включен. \nЕсли поле серое — двигатель выключен.", R.drawable.driving_school_icon_engine_res, 2, new SpannableString("Открыть или закрыть двери"), 20, "Если поле горит зеленым — двери закрыты. \nЕсли поле серое — двери открыты.", Integer.valueOf((int) R.drawable.driving_school_icon_door_res), true));
        arrayList5.add(new SignObj(3, new SpannableString("Включить или выключить свет"), 23, "Если поле горит зеленым — фары включены. \nЕсли поле серое — фары выключены.", R.drawable.driving_school_icon_light_res, 4, new SpannableString("Забрать или вставить ключ"), 21, "Если поле горит зеленым — ключ вставлен. \nЕсли поле серое — ключ не в стартере, а это значит, что нельзя завести транспорт.", Integer.valueOf((int) R.drawable.driving_school_icon_key_res), true));
        arrayList5.add(new SignObj(5, new SpannableString("Припарковать свой автомобиль"), 18, "При выборе данной кнопки, Ваш автомобиль будет припаркован на месте, в котором Вы нажали эту кнопку.", R.drawable.driving_school_icon_parking_res, 6, new SpannableString("Управление вашей подвеской"), 17, "При выборе данной кнопки Вы сможете управлять вашей подвеской. Это доступно только на личном автомобиле, если Вы установите её в тюнинге.", Integer.valueOf((int) R.drawable.driving_school_icon_suspension_res), false));
        Unit unit5 = Unit.INSTANCE;
        radialMenuInfoCategoriesABCD = arrayList5;
        ArrayList arrayList6 = new ArrayList();
        arrayList6.add(new SignObj(1, new SpannableString("Включить или выключить двигатель"), 23, "Если поле горит зеленым — двигатель включен. \nЕсли поле серое — двигатель выключен.", R.drawable.driving_school_icon_engine_res, 2, new SpannableString("Открыть или закрыть двери"), 20, "Если поле горит зеленым — двери закрыты. \nЕсли поле серое — двери открыты.", Integer.valueOf((int) R.drawable.driving_school_icon_door_res), true));
        arrayList6.add(new SignObj(3, new SpannableString("Включить или выключить свет"), 23, "Если поле горит зеленым — фары включены. \nЕсли поле серое — фары выключены.", R.drawable.driving_school_icon_light_res, 4, new SpannableString("Забрать или вставить ключ"), 21, "Если поле горит зеленым — ключ вставлен. \nЕсли поле серое — ключ не в стартере, а это значит, что нельзя завести транспорт.", Integer.valueOf((int) R.drawable.driving_school_icon_key_res), false));
        Unit unit6 = Unit.INSTANCE;
        radialMenuInfoCategoriesShip = arrayList6;
    }

    public final List<SignObj> getRoadSignsCategoriesAB() {
        return roadSignsCategoriesAB;
    }

    public final List<SignObj> getRoadSignsCategoriesC() {
        return roadSignsCategoriesC;
    }

    public final List<SignObj> getRoadSignsCategoriesD() {
        return roadSignsCategoriesD;
    }

    public final List<SignObj> getRoadSignsCategoriesShip() {
        return roadSignsCategoriesShip;
    }

    public final List<SignObj> getRadialMenuInfoCategoriesABCD() {
        return radialMenuInfoCategoriesABCD;
    }

    public final List<SignObj> getRadialMenuInfoCategoriesShip() {
        return radialMenuInfoCategoriesShip;
    }
}
