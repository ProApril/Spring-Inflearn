package hello.core.scan;

import hello.core.scan.filter.BeanA;
import hello.core.scan.filter.MyExcludeComponent;
import hello.core.scan.filter.MyIncludeComponent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.system.ApplicationPid;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import static org.assertj.core.api.Assertions.*;


public class ComponentFilterAppConfigTest {

    @Test
    void filterScan(){
        ApplicationContext ac  =new AnnotationConfigApplicationContext(ComponetFilterAppConfig.class);
        BeanA beanA = ac.getBean("beanA",BeanA.class);
        assertThat(beanA).isNotNull();

        Assertions.assertThrows(
                NoSuchBeanDefinitionException.class,() -> ac.getBean("beanB",BeanA.class) // B는 exclude이기때문에 에러남.
        );
    }

    @Configuration
    @ComponentScan(
            includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes= MyIncludeComponent.class),
            excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes= MyExcludeComponent.class)
    )

    static class ComponetFilterAppConfig{}
}
