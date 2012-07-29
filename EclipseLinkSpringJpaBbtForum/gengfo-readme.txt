=============================================================Original Spring enterprise readme
 同时用Annotation和XML对领域对象进行持久化JPA映射配置时，
  在测试时产生了一些问题，故此，把带Annotation的领域对象
  备份在bak/domain中，而在src/下的领域对象未使用Annotation。

=============================================================GengFo readme
Spring JPA Configuration Steps
1. transactionManager -> JpaTransactionManager, property name: entityManagerFactory；属性1：entityManagerFactory； 属性2：dataSource？
2. <tx:annotation-driven /> -> transaction-manager=jpaTxManager
2. entityManagerFactory -> LocalContainerEntityManagerFactoryBean; 这个注入可以获取JpaTemplate; 属性1： dataSource？, 属性2： jpaVendorAdaptor
3. define datasource -> driver class; url; user; password
4. define DAO bean
	<bean id="forumDao"
		class="org.springframework.transaction.interceptor.TransactionProxyFactoryBean">
		<property name="transactionManager" ref="transactionManager" />
		<property name="target">
			<bean class="com.baobaotao.dao.jpa.ForumJpaDao" autowire="autodetect" />
		</property>
		<property name="transactionAttributes">
			<props>
				<prop key="*">PROPAGATION_REQUIRED</prop>
			</props>
		</property>
	</bean>
	
5. persistence.xml config
	属性1： persistence-unit name
	属性2： transaction-type
	元素：provider
	jpa mapping 类： ***.Invoice
	
	