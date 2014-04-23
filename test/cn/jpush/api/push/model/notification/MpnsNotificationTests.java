package cn.jpush.api.push.model.notification;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class MpnsNotificationTests {

    @Test(expected = IllegalArgumentException.class)
    public void testIllegal() {
        MpnsNotification mpns = MpnsNotification.newBuilder().build();
        Assert.assertEquals("", "", mpns.toJSON());
    }
    
    @Test
    public void testQuickAlert() {
        MpnsNotification mpns = MpnsNotification.alert("aaa");
        JsonObject json = new JsonObject();
        json.add("alert", new JsonPrimitive("aaa"));
        Assert.assertEquals("", json, mpns.toJSON());
    }

    @Test
    public void testTitle() {
        MpnsNotification mpns = MpnsNotification.newBuilder().setTitle("title").build();
        JsonObject json = new JsonObject();
        json.add("title", new JsonPrimitive("title"));
        Assert.assertEquals("", json, mpns.toJSON());
    }
    
    @Test
    public void testExtra() {
        MpnsNotification mpns = MpnsNotification.newBuilder().addExtra("key", "value").build();
        JsonObject json = new JsonObject();
        JsonObject extra = new JsonObject();
        extra.add("key", new JsonPrimitive("value"));
        json.add("extras", extra);
        Assert.assertEquals("", json, mpns.toJSON());
    }
    

}


