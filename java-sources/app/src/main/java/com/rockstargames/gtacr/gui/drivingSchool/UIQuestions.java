package com.rockstargames.gtacr.gui.drivingSchool;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import blackrussia.online.R;
import blackrussia.online.databinding.DrivingSchoolQuestionsLayoutBinding;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.nvidia.devtech.NvEventQueueActivity;
import com.rockstargames.gtacr.adapters.DrivingSchoolAnswersAdapter;
import com.rockstargames.gtacr.common.UILayout;
import com.rockstargames.gtacr.data.DrivingAnswer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010K\u001a\u00020F2\u0006\u0010L\u001a\u00020?H\u0003J\b\u0010M\u001a\u00020NH\u0016J\u001a\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010SH\u0016J\b\u0010T\u001a\u00020FH\u0016J\b\u0010U\u001a\u00020FH\u0016J\b\u0010V\u001a\u00020FH\u0002J&\u0010W\u001a\u00020F2\u0006\u0010X\u001a\u00020?2\u0006\u0010Y\u001a\u00020?2\u0006\u0010L\u001a\u00020?2\u0006\u0010Z\u001a\u00020?J\b\u0010[\u001a\u00020FH\u0002J\u0006\u0010\\\u001a\u00020FJ\u0006\u0010]\u001a\u00020FJ\u0006\u0010^\u001a\u00020FR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u00109\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010@\u001a:\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110?¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0004\u0012\u00020F\u0018\u00010Aj\u0004\u0018\u0001`GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082.¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/rockstargames/gtacr/gui/drivingSchool/UIQuestions;", "Lcom/rockstargames/gtacr/common/UILayout;", "mainRoot", "Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;", "context", "Lcom/nvidia/devtech/NvEventQueueActivity;", "(Lcom/rockstargames/gtacr/gui/drivingSchool/GUIDrivingSchool;Lcom/nvidia/devtech/NvEventQueueActivity;)V", "anim", "Landroid/view/animation/Animation;", "answer1", "", "Lcom/rockstargames/gtacr/data/DrivingAnswer;", "answer10", "answer11", "answer12", "answer13", "answer14", "answer15", "answer16", "answer17", "answer18", "answer19", "answer2", "answer20", "answer21", "answer22", "answer23", "answer24", "answer25", "answer26", "answer27", "answer28", "answer29", "answer3", "answer30", "answer31", "answer32", "answer33", "answer34", "answer35", "answer36", "answer37", "answer38", "answer39", "answer4", "answer40", "answer41", "answer42", "answer43", "answer44", "answer45", "answer46", "answer47", "answer5", "answer6", "answer7", "answer8", "answer9", "answersAdapter", "Lcom/rockstargames/gtacr/adapters/DrivingSchoolAnswersAdapter;", "binding", "Lblackrussia/online/databinding/DrivingSchoolQuestionsLayoutBinding;", "counterWithAnswer", "", "onAnswerClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", AppMeasurementSdk.ConditionalUserProperty.NAME, "item", "position", "", "Lcom/rockstargames/gtacr/gui/drivingSchool/OnAnswerClickListener;", "thisAnswers", "timer", "Landroid/os/CountDownTimer;", "getAnswersAndAllParameters", "thisQuestion", "getView", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onLayoutClose", "onLayoutShown", "setDataWithAnswers", "setInfoForQuestion", "questionsNumber", "valueCorrectQuestions", "allQuestions", "setLogicForClickAnswer", "setNullableParameters", "startTimer", "stopTimer", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UIQuestions extends UILayout {
    private Animation anim;
    private final List<DrivingAnswer> answer1;
    private final List<DrivingAnswer> answer10;
    private final List<DrivingAnswer> answer11;
    private final List<DrivingAnswer> answer12;
    private final List<DrivingAnswer> answer13;
    private final List<DrivingAnswer> answer14;
    private final List<DrivingAnswer> answer15;
    private final List<DrivingAnswer> answer16;
    private final List<DrivingAnswer> answer17;
    private final List<DrivingAnswer> answer18;
    private final List<DrivingAnswer> answer19;
    private final List<DrivingAnswer> answer2;
    private final List<DrivingAnswer> answer20;
    private final List<DrivingAnswer> answer21;
    private final List<DrivingAnswer> answer22;
    private final List<DrivingAnswer> answer23;
    private final List<DrivingAnswer> answer24;
    private final List<DrivingAnswer> answer25;
    private final List<DrivingAnswer> answer26;
    private final List<DrivingAnswer> answer27;
    private final List<DrivingAnswer> answer28;
    private final List<DrivingAnswer> answer29;
    private final List<DrivingAnswer> answer3;
    private final List<DrivingAnswer> answer30;
    private final List<DrivingAnswer> answer31;
    private final List<DrivingAnswer> answer32;
    private final List<DrivingAnswer> answer33;
    private final List<DrivingAnswer> answer34;
    private final List<DrivingAnswer> answer35;
    private final List<DrivingAnswer> answer36;
    private final List<DrivingAnswer> answer37;
    private final List<DrivingAnswer> answer38;
    private final List<DrivingAnswer> answer39;
    private final List<DrivingAnswer> answer4;
    private final List<DrivingAnswer> answer40;
    private final List<DrivingAnswer> answer41;
    private final List<DrivingAnswer> answer42;
    private final List<DrivingAnswer> answer43;
    private final List<DrivingAnswer> answer44;
    private final List<DrivingAnswer> answer45;
    private final List<DrivingAnswer> answer46;
    private final List<DrivingAnswer> answer47;
    private final List<DrivingAnswer> answer5;
    private final List<DrivingAnswer> answer6;
    private final List<DrivingAnswer> answer7;
    private final List<DrivingAnswer> answer8;
    private final List<DrivingAnswer> answer9;
    private DrivingSchoolAnswersAdapter answersAdapter;
    private DrivingSchoolQuestionsLayoutBinding binding;
    private final NvEventQueueActivity context;
    private final List<Integer> counterWithAnswer;
    private final GUIDrivingSchool mainRoot;
    private Function2<? super DrivingAnswer, ? super Integer, Unit> onAnswerClickListener;
    private List<DrivingAnswer> thisAnswers;
    private CountDownTimer timer;

    @Override
    public void onLayoutClose() {
    }

    @Override
    public void onLayoutShown() {
    }

    public UIQuestions(GUIDrivingSchool mainRoot, NvEventQueueActivity context) {
        Intrinsics.checkNotNullParameter(mainRoot, "mainRoot");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mainRoot = mainRoot;
        this.context = context;
        this.thisAnswers = new ArrayList();
        this.answer1 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_1_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_1_ANSWER_2, false, 4, null), new DrivingAnswer(2, Answers.QUESTION_1_ANSWER_3, false, 4, null), new DrivingAnswer(3, "Знак \"Главная дорога\" - водитель обязан остановиться перед краем проезжей части.", false, 4, null));
        this.answer2 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "При нажатии на гудок.", false, 4, null), new DrivingAnswer(1, "При помощи команды /radial.", false, 4, null), new DrivingAnswer(2, "При открытии настроек игры.", false, 4, null), new DrivingAnswer(3, "При помощи кнопки \"Меню\" под игровой картой.", false, 4, null));
        this.answer3 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "При помощи подсказки или кнопки в радиальном меню", false, 4, null), new DrivingAnswer(1, "При помощи команды /eng", false, 4, null), new DrivingAnswer(2, "При помощи двойного нажатия на гудок", false, 4, null), new DrivingAnswer(3, "Двигатель заводится автоматически", false, 4, null));
        this.answer4 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Включает двигатель", false, 4, null), new DrivingAnswer(1, "Открывает двери автомобиля", false, 4, null), new DrivingAnswer(2, "Включает или выключает освещение (свет)", false, 4, null), new DrivingAnswer(3, "Вызывает меню управления подвеской", false, 4, null));
        this.answer5 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Включает нейтральную передачу", false, 4, null), new DrivingAnswer(1, "Выключает двигатель автомобиля", false, 4, null), new DrivingAnswer(2, Answers.QUESTION_5_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_5_ANSWER_4, false, 4, null));
        this.answer6 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Открывает или закрывает двери", false, 4, null), new DrivingAnswer(1, "Открывает водительскую дверь", false, 4, null), new DrivingAnswer(2, "Выключает двигатель автомобиля", false, 4, null), new DrivingAnswer(3, "Достает ключ из автомобиля", false, 4, null));
        this.answer7 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Включает двигатель", false, 4, null), new DrivingAnswer(1, "Открывает двери автомобиля", false, 4, null), new DrivingAnswer(2, Answers.QUESTION_7_ANSWER_3, false, 4, null), new DrivingAnswer(3, "Выключает двигатель", false, 4, null));
        this.answer8 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_8_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Вставляет ключ в стартер или достает его", false, 4, null), new DrivingAnswer(2, "Открывает двери автомобиля", false, 4, null), new DrivingAnswer(3, "Включает нейтральную передачу", false, 4, null));
        this.answer9 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_9_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Открывает двери автомобиля", false, 4, null), new DrivingAnswer(2, "Включает двигатель", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_9_ANSWER_4, false, 4, null));
        this.answer10 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_10_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Способ взаимодействия с моим персонажем", false, 4, null), new DrivingAnswer(2, "Способ взаимодействия с моим домом", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_10_ANSWER_4, false, 4, null));
        this.answer11 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null), new DrivingAnswer(1, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением максимальной скорости\"", false, 4, null), new DrivingAnswer(2, "Данный знак запрещает остановку и стоянку транспортных средств. Распространяется только на одну сторону дороги.", false, 4, null), new DrivingAnswer(3, "Данный знак разрешает только движение прямо. Аналогичные знаки с движением направо, налево, разворотом и другими знаками.", false, 4, null));
        this.answer12 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null), new DrivingAnswer(1, Answers.QUESTION_12_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null), new DrivingAnswer(3, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", false, 4, null));
        this.answer13 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак обозначает специализированный наземный пешеходный переход, на котором водитель обязан уступить дорогу пешеходу. ", false, 4, null), new DrivingAnswer(1, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", false, 4, null), new DrivingAnswer(2, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null), new DrivingAnswer(3, "Этот знак запрещает движение всех транспортных средств, за исключением автомобилей предприятия, обслуживающего данную зону (Дальнобойщиков) и маршруртные автомобили.", false, 4, null));
        this.answer14 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_14_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением максимальной скорости\"", false, 4, null), new DrivingAnswer(2, "Этот знак запрещает обгон всех транспортных средств, движущихся по участку, на котором установлен этот знак.", false, 4, null), new DrivingAnswer(3, "Данный знак запрещает стоянку транспортных средств. Распространяется только на одну сторону дороги.", false, 4, null));
        this.answer15 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", false, 4, null), new DrivingAnswer(1, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null), new DrivingAnswer(2, "Этот знак запрещает движение всех транспортных средств, за исключением автомобилей предприятия, обслуживающего данную зону (Дальнобойщиков) и маршруртные автомобили.", false, 4, null), new DrivingAnswer(3, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null));
        this.answer16 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением максимальной скорости\"", false, 4, null), new DrivingAnswer(1, "Знак обозначает специализированный наземный пешеходный переход, на котором водитель обязан уступить дорогу пешеходу. ", false, 4, null), new DrivingAnswer(2, "Этот знак запрещает обгон всех транспортных средств, движущихся по участку, на котором установлен этот знак.", false, 4, null), new DrivingAnswer(3, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", false, 4, null));
        this.answer17 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак обозначает специализированный наземный пешеходный переход, на котором водитель обязан уступить дорогу пешеходу. ", false, 4, null), new DrivingAnswer(1, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null), new DrivingAnswer(2, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением максимальной скорости\"", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_17_ANSWER_4, false, 4, null));
        this.answer18 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", false, 4, null), new DrivingAnswer(1, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением максимальной скорости\"", false, 4, null), new DrivingAnswer(2, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_18_ANSWER_4, false, 4, null));
        this.answer19 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_19_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null), new DrivingAnswer(2, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null), new DrivingAnswer(3, "Знак \"Главная дорога\" - водитель обязан остановиться перед краем проезжей части.", false, 4, null));
        this.answer20 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак \"Главная дорога\" - водитель обязан остановиться перед краем проезжей части.", false, 4, null), new DrivingAnswer(1, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением максимальной скорости\"", false, 4, null), new DrivingAnswer(2, Answers.QUESTION_20_ANSWER_3, false, 4, null), new DrivingAnswer(3, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", false, 4, null));
        this.answer21 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_21_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_21_ANSWER_2, false, 4, null), new DrivingAnswer(2, Answers.QUESTION_21_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_21_ANSWER_4, false, 4, null));
        this.answer22 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Зона, на которой ограничена минимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением минимальной скорости\"", false, 4, null), new DrivingAnswer(1, "Зона, на которой ограничена максимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением максимальной скорости\"", false, 4, null), new DrivingAnswer(2, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null), new DrivingAnswer(3, "Этот знак запрещает проезд контрольных пунктов без остановки. Такой знак ставят на постах ДПС, при пересечении границ.", false, 4, null));
        this.answer23 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_23_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_23_ANSWER_2, false, 4, null), new DrivingAnswer(2, Answers.QUESTION_23_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_23_ANSWER_4, false, 4, null));
        this.answer24 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null), new DrivingAnswer(1, Answers.QUESTION_24_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Знак обозначает специализированный наземный пешеходный переход, на котором водитель обязан уступить дорогу пешеходу. ", false, 4, null), new DrivingAnswer(3, "Зона, на которой ограничена минимальная скорость движения. Зона действует до знака \"Конец зоны с ограничением минимальной скорости\"", false, 4, null));
        this.answer25 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак обозначает начало населенного пункта. После этого знака ограничение скорости - 60км/ч (Максимальная скорость в населенных пунктах)", false, 4, null), new DrivingAnswer(1, "Знак обозначает конец населенного пункта. После этого знака ограничение скорости - 80 км/ч.", false, 4, null), new DrivingAnswer(2, Answers.QUESTION_25_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_25_ANSWER_4, false, 4, null));
        this.answer26 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_26_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Знак обозначает конец населенного пункта. После этого знака ограничение скорости - 80 км/ч.", false, 4, null), new DrivingAnswer(2, "Знак обозначает начало населенного пункта. После этого знака ограничение скорости - 60км/ч (Максимальная скорость в населенных пунктах)", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_26_ANSWER_4, false, 4, null));
        this.answer27 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_27_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_27_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_27_ANSWER_4, false, 4, null));
        this.answer28 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_28_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Данный знак запрещает стоянку транспортных средств. Распространяется только на одну сторону дороги.", false, 4, null), new DrivingAnswer(2, "Данный знак запрещает остановку и стоянку транспортных средств. Распространяется только на одну сторону дороги.", false, 4, null), new DrivingAnswer(3, "Знак обозначает конец населенного пункта. После этого знака ограничение скорости - 80 км/ч.", false, 4, null));
        this.answer29 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Данный знак запрещает стоянку транспортных средств. Распространяется только на одну сторону дороги.", false, 4, null), new DrivingAnswer(1, "Данный знак запрещает остановку и стоянку транспортных средств. Распространяется только на одну сторону дороги.", false, 4, null), new DrivingAnswer(2, "Данный знак разрешает парковку на территории дороги.", false, 4, null), new DrivingAnswer(3, "Знак обозначает конец населенного пункта. После этого знака ограничение скорости - 80 км/ч.", false, 4, null));
        this.answer30 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак разрешает движение прямо, но запрещает поворот направо.", false, 4, null), new DrivingAnswer(1, Answers.QUESTION_30_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Знак разрешает движение прямо, но запрещает поворот налево.", false, 4, null), new DrivingAnswer(3, "Данный знак разрешает только движение прямо. Аналогичные знаки с движением направо, налево, разворотом и другими знаками.", false, 4, null));
        this.answer31 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак разрешает поворот направо, но запрещает налево.", false, 4, null), new DrivingAnswer(1, Answers.QUESTION_31_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Знак разрешает движение прямо, но запрещает поворот налево.", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_31_ANSWER_4, false, 4, null));
        this.answer32 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null), new DrivingAnswer(1, Answers.QUESTION_32_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Знак обозначает начало населенного пункта. После этого знака ограничение скорости - 60км/ч (Максимальная скорость в населенных пунктах)", false, 4, null), new DrivingAnswer(3, "Данный знак призывает водителя остановить свое транспортное средство перед СТОП-линией или перед краем пересекаемой проезжей части.", false, 4, null));
        this.answer33 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак разрешает движение прямо, но запрещает поворот налево.", false, 4, null), new DrivingAnswer(1, "Данный знак показывает водителю, что он двигается по второстепенной дороге и обязан уступить дорогу всем автомобилям, движущимся с преимуществом (В том числе справа)", false, 4, null), new DrivingAnswer(2, "Данный знак информирует о направлении движения для грузовых автомобилей. ", false, 4, null), new DrivingAnswer(3, "Знак разрешает движение прямо, но запрещает поворот направо.", false, 4, null));
        this.answer34 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_34_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_34_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Данный знак информирует о направлении движения для грузовых автомобилей. ", false, 4, null), new DrivingAnswer(3, "Данный знак разрешает парковку на территории дороги.", false, 4, null));
        this.answer35 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Знак разрешает движение прямо, но запрещает поворот направо.", false, 4, null), new DrivingAnswer(1, "Знак разрешает поворот направо, но запрещает налево.", false, 4, null), new DrivingAnswer(2, "Знак разрешает движение прямо, но запрещает поворот налево.", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_35_ANSWER_4, false, 4, null));
        this.answer36 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_36_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_36_ANSWER_2, false, 4, null), new DrivingAnswer(2, "Знак разрешает движение прямо, но запрещает поворот налево.", false, 4, null), new DrivingAnswer(3, "Знак разрешает движение прямо, но запрещает поворот направо.", false, 4, null));
        this.answer37 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "При нажатии на гудок.", false, 4, null), new DrivingAnswer(1, "При помощи команды /radial.", false, 4, null), new DrivingAnswer(2, "При открытии настроек игры.", false, 4, null), new DrivingAnswer(3, "При помощи кнопки \"Меню\" под игровой картой.", false, 4, null));
        this.answer38 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "При помощи подсказки или кнопки в радиальном меню", false, 4, null), new DrivingAnswer(1, "При помощи команды /eng", false, 4, null), new DrivingAnswer(2, "При помощи двойного нажатия на гудок", false, 4, null), new DrivingAnswer(3, "Двигатель заводится автоматически", false, 4, null));
        this.answer39 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Включает двигатель", false, 4, null), new DrivingAnswer(1, "Открывает двери автомобиля", false, 4, null), new DrivingAnswer(2, "Включает или выключает освещение (свет)", false, 4, null), new DrivingAnswer(3, "Вызывает меню управления подвеской", false, 4, null));
        this.answer40 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Открывает или закрывает двери", false, 4, null), new DrivingAnswer(1, "Открывает водительскую дверь", false, 4, null), new DrivingAnswer(2, "Выключает двигатель автомобиля", false, 4, null), new DrivingAnswer(3, "Достает ключ из автомобиля", false, 4, null));
        this.answer41 = CollectionsKt.mutableListOf(new DrivingAnswer(0, "Включает двигатель", false, 4, null), new DrivingAnswer(1, "Открывает двери автомобиля", false, 4, null), new DrivingAnswer(2, Answers.QUESTION_41_ANSWER_3, false, 4, null), new DrivingAnswer(3, "Выключает двигатель", false, 4, null));
        this.answer42 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_42_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Вставляет ключ в стартер или достает его", false, 4, null), new DrivingAnswer(2, "Открывает двери автомобиля", false, 4, null), new DrivingAnswer(3, "Включает нейтральную передачу", false, 4, null));
        this.answer43 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_43_ANSWER_1, false, 4, null), new DrivingAnswer(1, "Способ взаимодействия с моим персонажем", false, 4, null), new DrivingAnswer(2, "Способ взаимодействия с моим домом", false, 4, null), new DrivingAnswer(3, Answers.QUESTION_43_ANSWER_4, false, 4, null));
        this.answer44 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_44_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_44_ANSWER_2, false, 4, null), new DrivingAnswer(2, Answers.QUESTION_44_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_44_ANSWER_4, false, 4, null));
        this.answer45 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_45_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_45_ANSWER_2, false, 4, null), new DrivingAnswer(2, Answers.QUESTION_45_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_45_ANSWER_4, false, 4, null));
        this.answer46 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_46_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_46_ANSWER_2, false, 4, null), new DrivingAnswer(2, Answers.QUESTION_46_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_46_ANSWER_4, false, 4, null));
        this.answer47 = CollectionsKt.mutableListOf(new DrivingAnswer(0, Answers.QUESTION_47_ANSWER_1, false, 4, null), new DrivingAnswer(1, Answers.QUESTION_47_ANSWER_2, false, 4, null), new DrivingAnswer(2, Answers.QUESTION_47_ANSWER_3, false, 4, null), new DrivingAnswer(3, Answers.QUESTION_47_ANSWER_4, false, 4, null));
        this.counterWithAnswer = CollectionsKt.mutableListOf(-1, 0);
    }

    @Override
    public View getView() {
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding = this.binding;
        if (drivingSchoolQuestionsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolQuestionsLayoutBinding = null;
        }
        ConstraintLayout root = drivingSchoolQuestionsLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    public final void setInfoForQuestion(int i, int i2, int i3, int i4) {
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding = this.binding;
        if (drivingSchoolQuestionsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolQuestionsLayoutBinding = null;
        }
        drivingSchoolQuestionsLayoutBinding.thisQuestionValue.setText(this.context.getString(R.string.driving_school_this_question, new Object[]{String.valueOf(i)}));
        drivingSchoolQuestionsLayoutBinding.valueCorrectAnswers.setText(this.context.getString(R.string.driving_school_value_answers, new Object[]{Integer.valueOf(i2), Integer.valueOf(i4)}));
        getAnswersAndAllParameters(i3);
        this.counterWithAnswer.set(0, -1);
        this.counterWithAnswer.set(1, 0);
    }

    private final void getAnswersAndAllParameters(int i) {
        String str = "Что такое радиальное меню? ";
        int i2 = R.drawable.driving_school_icon_key_res;
        switch (i) {
            case 1:
                List<DrivingAnswer> list = this.thisAnswers;
                list.clear();
                list.addAll(this.answer1);
                Unit unit = Unit.INSTANCE;
                i2 = R.drawable.ds_01_main_road;
                str = Answers.QUESTION_1;
                break;
            case 2:
                List<DrivingAnswer> list2 = this.thisAnswers;
                list2.clear();
                list2.addAll(this.answer2);
                Unit unit2 = Unit.INSTANCE;
                str = Answers.QUESTION_2;
                i2 = R.drawable.ds_02_questions_symbol;
                break;
            case 3:
                List<DrivingAnswer> list3 = this.thisAnswers;
                list3.clear();
                list3.addAll(this.answer3);
                Unit unit3 = Unit.INSTANCE;
                str = Answers.QUESTION_3;
                i2 = R.drawable.ds_02_questions_symbol;
                break;
            case 4:
                List<DrivingAnswer> list4 = this.thisAnswers;
                list4.clear();
                list4.addAll(this.answer4);
                Unit unit4 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                i2 = R.drawable.driving_school_icon_light_res;
                break;
            case 5:
                List<DrivingAnswer> list5 = this.thisAnswers;
                list5.clear();
                list5.addAll(this.answer5);
                Unit unit5 = Unit.INSTANCE;
                i2 = R.drawable.driving_school_icon_parking_res;
                str = "За что отвечает данная кнопка? ";
                break;
            case 6:
                List<DrivingAnswer> list6 = this.thisAnswers;
                list6.clear();
                list6.addAll(this.answer6);
                Unit unit6 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                i2 = R.drawable.driving_school_icon_door_res;
                break;
            case 7:
                List<DrivingAnswer> list7 = this.thisAnswers;
                list7.clear();
                list7.addAll(this.answer7);
                Unit unit7 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                i2 = R.drawable.driving_school_icon_engine_res;
                break;
            case 8:
                List<DrivingAnswer> list8 = this.thisAnswers;
                list8.clear();
                list8.addAll(this.answer8);
                Unit unit8 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                break;
            case 9:
                List<DrivingAnswer> list9 = this.thisAnswers;
                list9.clear();
                list9.addAll(this.answer9);
                Unit unit9 = Unit.INSTANCE;
                i2 = R.drawable.driving_school_icon_suspension_res;
                str = "За что отвечает данная кнопка? ";
                break;
            case 10:
                List<DrivingAnswer> list10 = this.thisAnswers;
                list10.clear();
                list10.addAll(this.answer10);
                Unit unit10 = Unit.INSTANCE;
                i2 = R.drawable.ds_02_questions_symbol;
                break;
            case 11:
                List<DrivingAnswer> list11 = this.thisAnswers;
                list11.clear();
                list11.addAll(this.answer11);
                Unit unit11 = Unit.INSTANCE;
                i2 = R.drawable.ds_02_stop;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 12:
                List<DrivingAnswer> list12 = this.thisAnswers;
                list12.clear();
                list12.addAll(this.answer12);
                Unit unit12 = Unit.INSTANCE;
                i2 = R.drawable.ds_03_no_entry;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 13:
                List<DrivingAnswer> list13 = this.thisAnswers;
                list13.clear();
                list13.addAll(this.answer13);
                Unit unit13 = Unit.INSTANCE;
                i2 = R.drawable.ds_04_no_drive;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 14:
                List<DrivingAnswer> list14 = this.thisAnswers;
                list14.clear();
                list14.addAll(this.answer14);
                Unit unit14 = Unit.INSTANCE;
                i2 = R.drawable.ds_05_max_hight;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 15:
                List<DrivingAnswer> list15 = this.thisAnswers;
                list15.clear();
                list15.addAll(this.answer15);
                Unit unit15 = Unit.INSTANCE;
                i2 = R.drawable.ds_06_control;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 16:
                List<DrivingAnswer> list16 = this.thisAnswers;
                list16.clear();
                list16.addAll(this.answer16);
                Unit unit16 = Unit.INSTANCE;
                i2 = R.drawable.ds_07_no_overtaking;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 17:
                List<DrivingAnswer> list17 = this.thisAnswers;
                list17.clear();
                list17.addAll(this.answer17);
                Unit unit17 = Unit.INSTANCE;
                i2 = R.drawable.ds_08_max_speed;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 18:
                List<DrivingAnswer> list18 = this.thisAnswers;
                list18.clear();
                list18.addAll(this.answer18);
                Unit unit18 = Unit.INSTANCE;
                i2 = R.drawable.ds_09_no_limitation;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 19:
                List<DrivingAnswer> list19 = this.thisAnswers;
                list19.clear();
                list19.addAll(this.answer19);
                Unit unit19 = Unit.INSTANCE;
                i2 = R.drawable.ds_10_ring_drive;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 20:
                List<DrivingAnswer> list20 = this.thisAnswers;
                list20.clear();
                list20.addAll(this.answer20);
                Unit unit20 = Unit.INSTANCE;
                i2 = R.drawable.ds_11_motorway;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 21:
                List<DrivingAnswer> list21 = this.thisAnswers;
                list21.clear();
                list21.addAll(this.answer21);
                Unit unit21 = Unit.INSTANCE;
                i2 = R.drawable.ds_12_bus_stop;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 22:
                List<DrivingAnswer> list22 = this.thisAnswers;
                list22.clear();
                list22.addAll(this.answer22);
                Unit unit22 = Unit.INSTANCE;
                i2 = R.drawable.ds_13_zone_max_speed;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 23:
                List<DrivingAnswer> list23 = this.thisAnswers;
                list23.clear();
                list23.addAll(this.answer23);
                Unit unit23 = Unit.INSTANCE;
                i2 = R.drawable.ds_14_parking;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 24:
                List<DrivingAnswer> list24 = this.thisAnswers;
                list24.clear();
                list24.addAll(this.answer24);
                Unit unit24 = Unit.INSTANCE;
                i2 = R.drawable.ds_15_crosswalk;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 25:
                List<DrivingAnswer> list25 = this.thisAnswers;
                list25.clear();
                list25.addAll(this.answer25);
                Unit unit25 = Unit.INSTANCE;
                i2 = R.drawable.ds_16_start_city;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 26:
                List<DrivingAnswer> list26 = this.thisAnswers;
                list26.clear();
                list26.addAll(this.answer26);
                Unit unit26 = Unit.INSTANCE;
                i2 = R.drawable.ds_17_end_city;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 27:
                List<DrivingAnswer> list27 = this.thisAnswers;
                list27.clear();
                list27.addAll(this.answer27);
                Unit unit27 = Unit.INSTANCE;
                i2 = R.drawable.ds_18_give_way;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 28:
                List<DrivingAnswer> list28 = this.thisAnswers;
                list28.clear();
                list28.addAll(this.answer28);
                Unit unit28 = Unit.INSTANCE;
                i2 = R.drawable.ds_19_no_stopes;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 29:
                List<DrivingAnswer> list29 = this.thisAnswers;
                list29.clear();
                list29.addAll(this.answer29);
                Unit unit29 = Unit.INSTANCE;
                i2 = R.drawable.ds_20_no_parking;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 30:
                List<DrivingAnswer> list30 = this.thisAnswers;
                list30.clear();
                list30.addAll(this.answer30);
                Unit unit30 = Unit.INSTANCE;
                i2 = R.drawable.ds_21_straight_ahead;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 31:
                List<DrivingAnswer> list31 = this.thisAnswers;
                list31.clear();
                list31.addAll(this.answer31);
                Unit unit31 = Unit.INSTANCE;
                i2 = R.drawable.ds_22_no_turn;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 32:
                List<DrivingAnswer> list32 = this.thisAnswers;
                list32.clear();
                list32.addAll(this.answer32);
                Unit unit32 = Unit.INSTANCE;
                i2 = R.drawable.ds_23_photo_control;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 33:
                List<DrivingAnswer> list33 = this.thisAnswers;
                list33.clear();
                list33.addAll(this.answer33);
                Unit unit33 = Unit.INSTANCE;
                i2 = R.drawable.ds_24_way_for_cargo_car;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 34:
                List<DrivingAnswer> list34 = this.thisAnswers;
                list34.clear();
                list34.addAll(this.answer34);
                Unit unit34 = Unit.INSTANCE;
                i2 = R.drawable.ds_25_no_overtaking_cargo_car;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 35:
                List<DrivingAnswer> list35 = this.thisAnswers;
                list35.clear();
                list35.addAll(this.answer35);
                Unit unit35 = Unit.INSTANCE;
                i2 = R.drawable.ds_26_no_way_for_big_cargo_car;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 36:
                List<DrivingAnswer> list36 = this.thisAnswers;
                list36.clear();
                list36.addAll(this.answer36);
                Unit unit36 = Unit.INSTANCE;
                i2 = R.drawable.ds_27_bus_road;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 37:
                List<DrivingAnswer> list37 = this.thisAnswers;
                list37.clear();
                list37.addAll(this.answer37);
                Unit unit37 = Unit.INSTANCE;
                str = Answers.QUESTION_37;
                i2 = R.drawable.ds_02_questions_symbol;
                break;
            case 38:
                List<DrivingAnswer> list38 = this.thisAnswers;
                list38.clear();
                list38.addAll(this.answer38);
                Unit unit38 = Unit.INSTANCE;
                str = Answers.QUESTION_38;
                i2 = R.drawable.ds_02_questions_symbol;
                break;
            case 39:
                List<DrivingAnswer> list39 = this.thisAnswers;
                list39.clear();
                list39.addAll(this.answer39);
                Unit unit39 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                i2 = R.drawable.driving_school_icon_light_res;
                break;
            case 40:
                List<DrivingAnswer> list40 = this.thisAnswers;
                list40.clear();
                list40.addAll(this.answer40);
                Unit unit40 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                i2 = R.drawable.driving_school_icon_door_res;
                break;
            case 41:
                List<DrivingAnswer> list41 = this.thisAnswers;
                list41.clear();
                list41.addAll(this.answer41);
                Unit unit41 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                i2 = R.drawable.driving_school_icon_engine_res;
                break;
            case 42:
                List<DrivingAnswer> list42 = this.thisAnswers;
                list42.clear();
                list42.addAll(this.answer42);
                Unit unit42 = Unit.INSTANCE;
                str = "За что отвечает данная кнопка? ";
                break;
            case 43:
                List<DrivingAnswer> list43 = this.thisAnswers;
                list43.clear();
                list43.addAll(this.answer43);
                Unit unit43 = Unit.INSTANCE;
                i2 = R.drawable.ds_02_questions_symbol;
                break;
            case 44:
                List<DrivingAnswer> list44 = this.thisAnswers;
                list44.clear();
                list44.addAll(this.answer44);
                Unit unit44 = Unit.INSTANCE;
                i2 = R.drawable.driving_school_icon_sign_no_drop_anchor_res;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 45:
                List<DrivingAnswer> list45 = this.thisAnswers;
                list45.clear();
                list45.addAll(this.answer45);
                Unit unit45 = Unit.INSTANCE;
                i2 = R.drawable.driving_school_icon_sign_stop_ship_res;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 46:
                List<DrivingAnswer> list46 = this.thisAnswers;
                list46.clear();
                list46.addAll(this.answer46);
                Unit unit46 = Unit.INSTANCE;
                i2 = R.drawable.driving_school_icon_sign_no_make_waves_res;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            case 47:
                List<DrivingAnswer> list47 = this.thisAnswers;
                list47.clear();
                list47.addAll(this.answer47);
                Unit unit47 = Unit.INSTANCE;
                i2 = R.drawable.driving_school_icon_sign_no_parking_ship_res;
                str = "Что означает знак, отображенный на картинке? ";
                break;
            default:
                i2 = 0;
                str = "";
                break;
        }
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding = this.binding;
        if (drivingSchoolQuestionsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolQuestionsLayoutBinding = null;
        }
        drivingSchoolQuestionsLayoutBinding.thisQuestionsText.setText(str);
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding2 = this.binding;
        if (drivingSchoolQuestionsLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolQuestionsLayoutBinding2 = null;
        }
        drivingSchoolQuestionsLayoutBinding2.questionsIconRes.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), i2, null));
        DrivingSchoolAnswersAdapter drivingSchoolAnswersAdapter = this.answersAdapter;
        if (drivingSchoolAnswersAdapter == null) {
            return;
        }
        drivingSchoolAnswersAdapter.notifyDataSetChanged();
        Unit unit48 = Unit.INSTANCE;
    }

    public final void startTimer() {
        CountDownTimer countDownTimer = new CountDownTimer(1000, 900) {
            @Override
            public void onTick(long j2) {
                String valueOf;
                String valueOf2;
                DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding;
                NvEventQueueActivity nvEventQueueActivity;
                long j3 = 60;
                long j4 = 1000;
                long j5 = (j2 / j3) / j4;
                if (String.valueOf(j5).length() == 1) {
                    valueOf = Intrinsics.stringPlus("0", Long.valueOf(j5));
                } else {
                    valueOf = String.valueOf(j5);
                }
                long j6 = (j2 - ((j5 * j3) * j4)) / j4;
                if (String.valueOf(j6).length() == 1) {
                    valueOf2 = Intrinsics.stringPlus("0", Long.valueOf(j6));
                } else {
                    valueOf2 = String.valueOf(j6);
                }
                drivingSchoolQuestionsLayoutBinding = UIQuestions.this.binding;
                if (drivingSchoolQuestionsLayoutBinding == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    drivingSchoolQuestionsLayoutBinding = null;
                }
                TextView textView = drivingSchoolQuestionsLayoutBinding.valueTimer;
                nvEventQueueActivity = UIQuestions.this.context;
                textView.setText(nvEventQueueActivity.getString(R.string.driving_school_timer, new Object[]{valueOf, valueOf2}));
            }

            @Override
            public void onFinish() {
                GUIDrivingSchool gUIDrivingSchool;
                gUIDrivingSchool = UIQuestions.this.mainRoot;
                gUIDrivingSchool.sendToServerClickButton(4);
            }
        };
        this.timer = countDownTimer;
        if (countDownTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            countDownTimer = null;
        }
        countDownTimer.start();
    }

    public final void stopTimer() {
        CountDownTimer countDownTimer = this.timer;
        if (countDownTimer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("timer");
            countDownTimer = null;
        }
        countDownTimer.cancel();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        DrivingSchoolQuestionsLayoutBinding inflate = DrivingSchoolQuestionsLayoutBinding.inflate(inflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(inflater)");
        this.binding = inflate;
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        this.anim = AnimationUtils.loadAnimation(inflate.getRoot().getContext(), R.anim.button_click);
        setLogicForClickAnswer();
        setDataWithAnswers();
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding2 = this.binding;
        if (drivingSchoolQuestionsLayoutBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolQuestionsLayoutBinding = drivingSchoolQuestionsLayoutBinding2;
        }
        ConstraintLayout root = drivingSchoolQuestionsLayoutBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    private final void setLogicForClickAnswer() {
        this.onAnswerClickListener = new Function2<DrivingAnswer, Integer, Unit>() {
            @Override
            public Unit invoke(DrivingAnswer drivingAnswer, Integer num) {
                invoke(drivingAnswer, num.intValue());
                return Unit.INSTANCE;
            }

            public void invoke(DrivingAnswer item, int i) {
                DrivingSchoolAnswersAdapter drivingSchoolAnswersAdapter;
                List list;
                List list2;
                List list3;
                List list4;
                GUIDrivingSchool gUIDrivingSchool;
                Intrinsics.checkNotNullParameter(item, "item");
                item.setChecked(true);
                drivingSchoolAnswersAdapter = UIQuestions.this.answersAdapter;
                if (drivingSchoolAnswersAdapter != null) {
                    drivingSchoolAnswersAdapter.notifyItemChanged(i);
                    drivingSchoolAnswersAdapter.setOnlyItemCheck(i);
                }
                list = UIQuestions.this.counterWithAnswer;
                if (((Number) list.get(0)).intValue() == item.getId()) {
                    list4 = UIQuestions.this.counterWithAnswer;
                    if (((Number) list4.get(1)).intValue() == 1) {
                        gUIDrivingSchool = UIQuestions.this.mainRoot;
                        gUIDrivingSchool.sendForServerCheckAnswer(item.getId());
                        return;
                    }
                }
                list2 = UIQuestions.this.counterWithAnswer;
                list2.set(0, Integer.valueOf(item.getId()));
                list3 = UIQuestions.this.counterWithAnswer;
                list3.set(1, 1);
            }
        };
    }

    private final void setDataWithAnswers() {
        this.answersAdapter = new DrivingSchoolAnswersAdapter(this.context, this.thisAnswers, this.onAnswerClickListener);
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding = this.binding;
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding2 = null;
        if (drivingSchoolQuestionsLayoutBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            drivingSchoolQuestionsLayoutBinding = null;
        }
        RecyclerView recyclerView = drivingSchoolQuestionsLayoutBinding.answersList;
        DrivingSchoolQuestionsLayoutBinding drivingSchoolQuestionsLayoutBinding3 = this.binding;
        if (drivingSchoolQuestionsLayoutBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            drivingSchoolQuestionsLayoutBinding2 = drivingSchoolQuestionsLayoutBinding3;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(drivingSchoolQuestionsLayoutBinding2.getRoot().getContext(), 1, false));
        recyclerView.setAdapter(this.answersAdapter);
    }

    public final void setNullableParameters() {
        this.anim = null;
        this.onAnswerClickListener = null;
        this.answersAdapter = null;
    }
}
