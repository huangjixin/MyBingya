<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/admin/include/taglib.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<jsp:include page="meta-channel.jsp" flush="true"></jsp:include>
<jsp:include page="css.jsp" flush="true"></jsp:include>
<jsp:include page="js.jsp" flush="true"></jsp:include>
<title>${channel.name}_广州智沃——专业的互联网营销策划与人才服务商</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true"></jsp:include>
	<jsp:include page="menu.jsp" flush="true"></jsp:include>
	<div class="globalWidth" id="banner">
		<img alt="" src="${ctx}/images/aboutus_banner.jpg"
			style="width: 100%;">
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="font-size: 12px;color:#333333;">当前位置： <a
				href="${ctx}/"
				style="font-size: 12px;text-decoration: none;color:#333333;">首页</a>
				<c:if test="${navChan !=null}">
					<c:forEach var="chan" items="${navChan}">
										><a href="${ctx}/${chan.linkAddr}"
							style="font-size: 12px;text-decoration: none;color:#333333;">${chan.name}</a>
					</c:forEach>
				</c:if>
			</span>
		</div>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;position: relative;">
			<span style="color:#333333;font-size: 30px;">ABOUT关于我们</span><span
				style="color:#333333;font-size: 12px;">最专业的互联网营销策划与人才提供商！</span>
		</div>
		<hr class="hr"></hr>
	</div>
	<div class="globalWidth">
		<div class="contentWidth" style="text-align: left;padding: 5px 0;">
			<c:forEach items="${navChan}" var="chan" varStatus="status">
				<c:if test="${status.index==0}">
					<c:if test="${chan.children!=null}">
						<c:set var="chan" value="${chan}" scope="request" />
						<jsp:include page="subnav.jsp"></jsp:include>
					</c:if>
				</c:if>
			</c:forEach>
		</div>
		<div class="contentWidth" style="text-align: left;padding: 5px 0;font-size: 14px;">
			<div><span style="color:#4B8DF9;font-size: 30px;">公司简介</span><span
				style="color:#333333;font-size: 12px;">COMPANY</span></div>
			<div style="padding: 5px 0;color: red;">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;广州智沃信息科技有限公司——专业的互联网营销策划与人才服务商。
			</div>
			<div>
				<p><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;北京纵横时光信息技术有限公司成立于2013年，隶属于北京集翔信息技术集团有限公司（以下简称“集团”），集团是一家以互联网产业为主，服务范围涉及：互联网咨询、二手房电商、互联网健康、互联网金融、移动互联网、百度推广、网站建设等七大业务板块的多元化产业集团。2014年形成了以北京为核心，以天津、广西、四川、深圳为基础，业务范围辐射全国的战略性布局。</p>
			</div>
			<div>
				<p><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;纵横时光作为中国领先的互联网营销服务机构，将集团多年来沉淀的丰富的互联网营销经验以及强大的实战经验进行整合，为国内外企业级客户提供一体化的互联网网络营销体检、网销运营策划、营销型网站建设、网销人才输送、网销咨询方案等服务。纵横时光致力于帮助传统业务企业提高网络营销竞争力，实现产品营销方式的迅速升级，创造出差异化的、可持续的竞争优势，发掘并创造互联网营销时代的商业价值。</p>
			</div>
			<div>
				<p><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;公司与众多成长型中小企业展开互联网全网营销诊断与策划服务，业内最完善的33条互联网营销推广诊断标准、最实用的引导式互联网营销策划培训、最完善的企业营销人才输送机制帮助企业用户快速建立高效的互联网营销体系，以达到节约推广成本、提高产品销量、提升品牌影响力的现实需求。目前公司已将服务推广到制造、化工、电子、建筑、汽车、餐饮、服装等与国民经济息息相关的领域，傲人的成绩令业界备受瞩目。</p>
			</div>
			<div>
				<p><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;纵横时光将以“汇科技能量，创智慧人生”为使命，以创新保证公司的技术领先地位，以求实研发生产出能真正给用户提供最大网络营销价值的技术与产品，以真诚的态度和专业的团队为企业提供满意的服务与技术支持。</p>
			</div>
			<div style="height: 15px;"></div>
			<hr class="hr" style="border-top:1px dashed #cccccc;padding: 15px 0;"></hr>	
		</div>
	</div>
	<jsp:include page="footer.jsp" flush="true"></jsp:include>
</body>
</html>
