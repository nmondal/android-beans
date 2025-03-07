package mini2Dx.android.beans;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mini2Dx.android.beans.BeanInfo;
import org.mini2Dx.android.beans.Introspector;
import org.mini2Dx.android.beans.PropertyDescriptor;
import org.mini2Dx.beanutils.PropertyUtilsBean;

public class PropertyTest {

    private BeanInfo bi;
    private SomeTestPOJOClass subject;

    @Before
    public void setup() throws Exception {
        subject = new SomeTestPOJOClass();
        bi = Introspector.getBeanInfo(SomeTestPOJOClass.class);
    }

    @Test
    public void beanPropertyDescriptorTest() {
        PropertyDescriptor[] pds = bi.getPropertyDescriptors();
        Assert.assertNotNull(pds);
        Assert.assertEquals(5, pds.length);
    }

    @Test
    public void beanPropertyGetValueTest() throws Exception {
        PropertyUtilsBean pb = new PropertyUtilsBean();
        int i = pb.getProperty(subject,"i");
        Assert.assertEquals(0, i);
        double d = pb.getProperty(subject,"d");
        Assert.assertEquals(42.0, d, 0.01 );
        boolean b = pb.getProperty(subject,"someBoolean");
        Assert.assertFalse(b);
    }

    @Test
    public void beanPropertySetValueTest() throws Exception {
        PropertyUtilsBean pb = new PropertyUtilsBean();
        pb.setProperty(subject,"i", 42);
        Assert.assertEquals(42, subject.getI());
        pb.setProperty(subject,"someBoolean", true);
        boolean b = pb.getProperty(subject,"someBoolean");
        Assert.assertTrue(b);
    }
}
