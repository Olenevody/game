var editUser = {
	id : $('#editUserId'),
	name : $('#editUserName'),
	email : $('#editUserEmail'),
	date : $('#editUserDate'),
	role : $('#editUserRole')
}

$('#Users tbody a').on('click', function(event) {
	event.preventDefault();
	var cols = $('td', $('#Users tbody a').closest("tr"));
	editUser.id.val(cols.eq(1).html());
	editUser.name.val(cols.eq(2).html());
	editUser.email.val(cols.eq(3).html());
	editUser.date.val(cols.eq(4).html());
	editUser.role.val(cols.eq(5).html());
	$('#editUser').modal({
		backdrop: 'static',
		show : true
	})
})

$('#editUserSubmit').on('click', function() {
	$('#editUserForm').submit();
})

editUser.date.datepicker({ dateFormat: 'yy-mm-dd' });