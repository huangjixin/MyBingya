<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="shiro" uri="/WEB-INF/admin/tlds/shiros.tld" %>
<%@ taglib prefix="fns" uri="/WEB-INF/admin/tlds/fns.tld" %>
<c:set var="ctxAdmin" value="${pageContext.request.contextPath}/${fns:getAdminPath()}"/>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>