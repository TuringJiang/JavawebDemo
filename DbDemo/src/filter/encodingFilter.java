package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class encodingFilter
 */
public class encodingFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public encodingFilter() {
		// TODO Auto-generated constructor stub
		System.out.println("回掉字符集过滤器的无参构造方法。");
	}

	/**
	 * @see Filter#destroy()
	 */
	private String charset;
	private boolean flag;

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("销毁字符集过滤器。");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		if (flag && charset != null) {
			request.setCharacterEncoding(charset);
			response.setCharacterEncoding(charset);
		} else {
			System.out.println("没有使用字符集过滤器。");
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.charset = fConfig.getInitParameter("charset");
		// 从配置文件中获取字符集的编码给charset;
		this.flag = "true".equals(fConfig.getInitParameter("flag"));
		// 设置字符集设定标志flag;

		System.out.println("设置字符集的编码方式为：" + charset + "\t是否启用" + flag);
	}

}
