=============================================================Original Spring enterprise readme
 ͬʱ��Annotation��XML�����������г־û�JPAӳ������ʱ��
  �ڲ���ʱ������һЩ���⣬�ʴˣ��Ѵ�Annotation���������
  ������bak/domain�У�����src/�µ��������δʹ��Annotation��

=============================================================GengFo readme
Spring JPA Configuration Steps
1. transactionManager -> JpaTransactionManager, property name: entityManagerFactory������1��entityManagerFactory�� ����2��dataSource��
2. <tx:annotation-driven /> -> transaction-manager=jpaTxManager
2. entityManagerFactory -> LocalContainerEntityManagerFactoryBean; ���ע����Ի�ȡJpaTemplate; ����1�� dataSource��, ����2�� jpaVendorAdaptor
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
	����1�� persistence-unit name
	����2�� transaction-type
	Ԫ�أ�provider
	jpa mapping �ࣺ ***.Invoice
	
	