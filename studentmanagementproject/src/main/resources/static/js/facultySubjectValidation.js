
/*<![CDATA[*/
function fetchSubjects() {
	var department = document.getElementById("faculty_department").value;

	// Use AJAX to fetch subjects based on the selected department
	$.ajax({
		type: "GET",
		url: /*[[@{/fetchSubjects}]]*/ '/fetchSubjects',
		data: {
			SubjectDepartment: department // Pass the department name as a query parameter
		},
		success: function(data) {
			// Populate the subject dropdown with the fetched data
			var select = document.getElementById("faculty_subject");
			select.innerHTML = "";

			for (var i = 0; i < data.length; i++) {
				var option = document.createElement("option");
				option.value = data[i];
				option.text = data[i];
				select.appendChild(option);
			}
		},
		error: function(xhr, status, error) {
			console.error(xhr.responseText);
		}
	});
}
/*]]>*/
