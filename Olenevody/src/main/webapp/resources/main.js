var editUser = {
	id : $('#editUserId'),
	name : $('#editUserName'),
	email : $('#editUserEmail'),
	date : $('#editUserDate'),
	role : $('#editUserRole')
}

$('#Users tbody tr').on('click', function() {
	var cols = $("td", this);
	editUser.id.val(cols.eq(1).html());
	editUser.name.val(cols.eq(2).html());
	editUser.email.val(cols.eq(3).html());
	editUser.date.val(cols.eq(4).html());
	editUser.role.val(cols.eq(5).html());
	$('#editUser').modal({
		show : true
	})
})

$('#editUserSubmit').on('click', function() {
	$('#editUserForm').submit();
})

editUser.date.datepicker({ dateFormat: 'yy-mm-dd' });