<%@ include file="/layout/header.jsp" %>

		<div id="fh5co-contact">
			<div class="container">
				<div class="col-md-6 animate-box">
					<h3>login</h3>
					<form action="login.do">
						<div class="row form-group">
							<div class="col-md-6">
								<input type="text" name="id" class="form-control"
									placeholder="id"> <input type="password" name="pw"
									class="form-control" placeholder="password">
							</div>
						</div>

						<div class="form-group">
							<input type="submit" value="Login" class="btn btn-primary">
							<input type="button" value="Join" class="btn btn-primary" onclick="location.href='joinForm.do'">
						</div>
					</form>
				</div>
			</div>
		</div>



	<%@ include file="/layout/footer.jsp" %>
