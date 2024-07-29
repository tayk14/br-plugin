package blackrussia.online.network;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

//@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lblackrussia/online/network/Story;", "", "title", "", "text", "image", "link", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getImage", "()Ljava/lang/String;", "setImage", "(Ljava/lang/String;)V", "getLink", "setLink", "getText", "setText", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_cppRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Story {
    @SerializedName("image")
    private String image;
    @SerializedName("link")
    private String link;
    @SerializedName("text")
    private String text;
    @SerializedName("title")
    private String title;

    public static Story copy$default(Story story, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = story.title;
        }
        if ((i & 2) != 0) {
            str2 = story.text;
        }
        if ((i & 4) != 0) {
            str3 = story.image;
        }
        if ((i & 8) != 0) {
            str4 = story.link;
        }
        return story.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.text;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.link;
    }

    public final Story copy(String title, String text, String image, String link) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(link, "link");
        return new Story(title, text, image, link);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Story) {
            Story story = (Story) obj;
            return Intrinsics.areEqual(this.title, story.title) && Intrinsics.areEqual(this.text, story.text) && Intrinsics.areEqual(this.image, story.image) && Intrinsics.areEqual(this.link, story.link);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.text.hashCode()) * 31) + this.image.hashCode()) * 31) + this.link.hashCode();
    }

    public String toString() {
        return "Story(title=" + this.title + ", text=" + this.text + ", image=" + this.image + ", link=" + this.link + ')';
    }

    public Story(String title, String text, String image, String link) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(image, "image");
        Intrinsics.checkNotNullParameter(link, "link");
        this.title = title;
        this.text = text;
        this.image = image;
        this.link = link;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.text = str;
    }

    public final String getImage() {
        return this.image;
    }

    public final void setImage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.image = str;
    }

    public final String getLink() {
        return this.link;
    }

    public final void setLink(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }
}
