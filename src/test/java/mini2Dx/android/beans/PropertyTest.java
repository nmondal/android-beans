package mini2Dx.android.beans;

import org.junit.Assert;
import org.junit.Test;
import org.mini2Dx.android.beans.BeanInfo;
import org.mini2Dx.android.beans.Introspector;
import org.mini2Dx.android.beans.PropertyDescriptor;

public class PropertyTest {

    private final SomeTestPOJOClass subject = new SomeTestPOJOClass();

    @Test
    public void beanPropertyTest() throws Exception {
        BeanInfo bi = Introspector.getBeanInfo( subject.getClass());
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        Assert.assertNotNull(pds);
        Assert.assertEquals(3, pds.length);
    }
}
