package br.spoj.command;

import org.junit.Test;

import junit.framework.Assert;


public class SpojHostTest {

	@Test
	public void submissionResultIdentification_Armenian() {
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.ARMENIAN.getSubmissionResult("լուծված է"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("0"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("13.04"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ARMENIAN.getSubmissionResult("սխալ կատարման ընթացքում  (SIGABRT)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ARMENIAN.getSubmissionResult("սխալ կատարման ընթացքում  (SIGSEGV)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ARMENIAN.getSubmissionResult("սխալ կատարման ընթացքում  (NZEC)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ARMENIAN.getSubmissionResult("սխալ կատարման ընթացքում  (SIGFPE)"));
		Assert.assertEquals(SubmissionResult.COMPILATION_ERROR, SpojHost.ARMENIAN.getSubmissionResult("կոմպիլյացիայի սխալ"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.ARMENIAN.getSubmissionResult("սխալ պատասխան"));
		Assert.assertEquals(SubmissionResult.TIME_LIMIT_EXCEEDED, SpojHost.ARMENIAN.getSubmissionResult("ժամանակի սահմանափակումը գերազանցված է"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("zaakceptowano"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("aceito"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("Đạt yêu cầu"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("błędna odpowiedź"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("resposta errada"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("kết quả sai"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("kết quả sai WA-test-0"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("przekroczono limit czasu"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("tempo limite excedido"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("chạy quá lâu"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("błąd wykonania (NZEC)"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("erro em tempo de execução (NZEC)"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("chạy bị lỗi (NZEC)"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("błąd kompilacji"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("erro de compilação"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("biên dịch gặp lỗi"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("accepted "));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("10 "));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult(" accepted"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("runtime error ()"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult(" 10"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult(""));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult(" "));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("1 (limit: 2)"));
		Assert.assertEquals(null, SpojHost.ARMENIAN.getSubmissionResult("2.5 (threshold: 3)"));
	}
	
	@Test
	public void submissionResultIdentification_English() {
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.ENGLISH.getSubmissionResult("accepted"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.ENGLISH.getSubmissionResult("0"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.ENGLISH.getSubmissionResult("10"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("1392.041"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("13.04"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ENGLISH.getSubmissionResult("runtime error (SIGABRT)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ENGLISH.getSubmissionResult("runtime error (SIGSEGV)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ENGLISH.getSubmissionResult("runtime error (NZEC)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.ENGLISH.getSubmissionResult("runtime error (SIGFPE)"));
		Assert.assertEquals(SubmissionResult.COMPILATION_ERROR, SpojHost.ENGLISH.getSubmissionResult("compilation error"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.ENGLISH.getSubmissionResult("wrong answer"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.ENGLISH.getSubmissionResult("wrong answer #0"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("zaakceptowano"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("aceito"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("Đạt yêu cầu"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("błędna odpowiedź"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("resposta errada"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("kết quả sai"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("kết quả sai WA-test-0"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("przekroczono limit czasu"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("tempo limite excedido"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("chạy quá lâu"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("błąd wykonania (NZEC)"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("erro em tempo de execução (NZEC)"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("chạy bị lỗi (NZEC)"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("błąd kompilacji"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("erro de compilação"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("biên dịch gặp lỗi"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("accepted "));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("10 "));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult(" accepted"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("runtime error ()"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult(" 10"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult(""));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult(" "));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("1 (limit: 2)"));
		Assert.assertEquals(null, SpojHost.ENGLISH.getSubmissionResult("2.5 (threshold: 3)"));
	}
	
	@Test
	public void submissionResultIdentification_Polish() {
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("accepted"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.POLISH.getSubmissionResult("0"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.POLISH.getSubmissionResult("10"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("1392.041"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("13.04"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("runtime error (SIGABRT)"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("runtime error (SIGSEGV)"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("runtime error (NZEC)"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("runtime error (SIGFPE)"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("compilation error"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("wrong answer"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("wrong answer #0"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.POLISH.getSubmissionResult("zaakceptowano"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("aceito"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("Đạt yêu cầu"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.POLISH.getSubmissionResult("błędna odpowiedź"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("resposta errada"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("kết quả sai"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("kết quả sai WA-test-0"));
		Assert.assertEquals(SubmissionResult.TIME_LIMIT_EXCEEDED, SpojHost.POLISH.getSubmissionResult("przekroczono limit czasu"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("tempo limite excedido"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("chạy quá lâu"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.POLISH.getSubmissionResult("błąd wykonania (NZEC)"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("erro em tempo de execução (NZEC)"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("chạy bị lỗi (NZEC)"));
		Assert.assertEquals(SubmissionResult.COMPILATION_ERROR, SpojHost.POLISH.getSubmissionResult("błąd kompilacji"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("erro de compilação"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("biên dịch gặp lỗi"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("accepted "));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("10 "));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult(" accepted"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult("runtime error ()"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult(" 10"));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult(""));
		Assert.assertEquals(null, SpojHost.POLISH.getSubmissionResult(" "));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.POLISH.getSubmissionResult("1 (limit: 2)"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.POLISH.getSubmissionResult("2.5 (threshold: 3)"));
	}
	
	@Test
	public void submissionResultIdentification_Portuguese() {
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("accepted"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("0"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("10"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("1392.041"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("13.04"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("runtime error (SIGABRT)"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("runtime error (SIGSEGV)"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("runtime error (NZEC)"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("runtime error (SIGFPE)"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("compilation error"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("wrong answer"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("wrong answer #0"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("zaakceptowano"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.PORTUGUESE_BR.getSubmissionResult("aceito"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("Đạt yêu cầu"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("błędna odpowiedź"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.PORTUGUESE_BR.getSubmissionResult("resposta errada"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("kết quả sai"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("kết quả sai WA-test-0"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("przekroczono limit czasu"));
		Assert.assertEquals(SubmissionResult.TIME_LIMIT_EXCEEDED, SpojHost.PORTUGUESE_BR.getSubmissionResult("tempo limite excedido"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("chạy quá lâu"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("błąd wykonania (NZEC)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.PORTUGUESE_BR.getSubmissionResult("erro em tempo de execução (NZEC)"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("chạy bị lỗi (NZEC)"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("błąd kompilacji"));
		Assert.assertEquals(SubmissionResult.COMPILATION_ERROR, SpojHost.PORTUGUESE_BR.getSubmissionResult("erro de compilação"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("biên dịch gặp lỗi"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("accepted "));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("10 "));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult(" accepted"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("runtime error ()"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult(" 10"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult(""));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult(" "));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("1 (limit: 2)"));
		Assert.assertEquals(null, SpojHost.PORTUGUESE_BR.getSubmissionResult("2.5 (threshold: 3)"));
	}
	
	@Test
	public void submissionResultIdentification_Vietnamese() {
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("accepted"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.VIETNAMESE.getSubmissionResult("0"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.VIETNAMESE.getSubmissionResult("10"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.VIETNAMESE.getSubmissionResult("1392.041"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.VIETNAMESE.getSubmissionResult("13.04"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("runtime error (SIGABRT)"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("runtime error (SIGSEGV)"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("runtime error (NZEC)"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("runtime error (SIGFPE)"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("compilation error"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("wrong answer"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("wrong answer #0"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("zaakceptowano"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("aceito"));
		Assert.assertEquals(SubmissionResult.ACCEPTED, SpojHost.VIETNAMESE.getSubmissionResult("Đạt yêu cầu"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("błędna odpowiedź"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("resposta errada"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.VIETNAMESE.getSubmissionResult("kết quả sai"));
		Assert.assertEquals(SubmissionResult.WRONG_ANSWER, SpojHost.VIETNAMESE.getSubmissionResult("kết quả sai WA-test-0"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("przekroczono limit czasu"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("tempo limite excedido"));
		Assert.assertEquals(SubmissionResult.TIME_LIMIT_EXCEEDED, SpojHost.VIETNAMESE.getSubmissionResult("chạy quá lâu"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("błąd wykonania (NZEC)"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("erro em tempo de execução (NZEC)"));
		Assert.assertEquals(SubmissionResult.RUNTIME_ERROR, SpojHost.VIETNAMESE.getSubmissionResult("chạy bị lỗi (NZEC)"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("błąd kompilacji"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("erro de compilação"));
		Assert.assertEquals(SubmissionResult.COMPILATION_ERROR, SpojHost.VIETNAMESE.getSubmissionResult("biên dịch gặp lỗi"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("accepted "));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("10 "));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult(" accepted"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("runtime error ()"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult(" 10"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult(""));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult(" "));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("1 (limit: 2)"));
		Assert.assertEquals(null, SpojHost.VIETNAMESE.getSubmissionResult("2.5 (threshold: 3)"));
	}
	
}
