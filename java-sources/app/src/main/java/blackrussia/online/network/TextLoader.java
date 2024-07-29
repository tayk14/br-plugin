package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0010"}, d2 = {"Lblackrussia/online/network/TextLoader;", "", "text", "", "(Ljava/lang/String;)V", "getText", "()Ljava/lang/String;", "setText", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextLoader {
    @SerializedName("text")
    private String text;

    public static TextLoader copy$default(TextLoader textLoader, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textLoader.text;
        }
        return textLoader.copy(str);
    }

    public final String component1() {
        return this.text;
    }

    public final TextLoader copy(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        return new TextLoader(text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TextLoader) && Intrinsics.areEqual(this.text, ((TextLoader) obj).text);
    }

    public int hashCode() {
        return this.text.hashCode();
    }

    public String toString() {
        return "TextLoader(text=" + this.text + ')';
    }

    public TextLoader(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.text = text;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }
}
