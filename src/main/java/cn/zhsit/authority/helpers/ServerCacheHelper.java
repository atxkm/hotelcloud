package cn.zhsit.authority.helpers;

import org.springframework.stereotype.Component;

/**
 * Created by Darren on 2017/7/7.
 */
@Component
public class ServerCacheHelper {
//    private static Logger log = LoggerFactory.getLogger(ServerCacheHelper.class);
//    @Autowired
//    private PersonAuthorityManager personAuthorityManager;
//
//       public void getPerson(Person person) {
//        PersonAuthority pa = personAuthorityManager.selectByKey(person.getId());
//
//    }


//    @Cacheable(value = ConstantsAuthority.ZhsPersonCacheName, key = "#personId",  unless = "#result == null")
//    public Person getPerson(String personId){
//        Wrapper<Person> wrapper = new Wrapper<Person>();
//        wrapper.setOpera(Wrapper.Opera.Find);
//        Person person=new Person();
//        person.setId(personId);
//        wrapper.setT(person);
//        log.info("从服务器端获取用户信息");
//        Wrapper<Person> wrapperBack= personServiceAuthority.personOpera(wrapper);
//        if (wrapperBack.getSuccess() != Boolean.TRUE) {
//            return null;
//        }
//        return wrapperBack.getT();
//    }

}
