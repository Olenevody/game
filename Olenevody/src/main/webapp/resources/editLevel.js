var codeRow =	"<tr>" +
					"<td><input type=\"checkbox\" /></td>" +
					"<td><input type=\"number\" /></td>" +
					"<td><input type=\"text\" /></td>" +
					"<td>2</td>" +
				"</tr>";

$('#addCodeBtn').on('click', function() {
	$('#Codes tbody').append(codeRow);
})