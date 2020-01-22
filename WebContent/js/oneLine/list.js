/**
 * 	reply javascript jquery
 */



function board_modify(select_bno,select_mno,session_mno)
{
	if(session_mno!=null && select_mno != null)
	{
		if(select_mno == session_mno)
		{
			console.log("수정 페이지로 이동합니다.");
		}
		else
		{
			alert("수정 권한이 없습니다.");
		}
	}
	else
	{
		alert("로그인이 필요합니다.");
		location.href="memberLogin.do";
	}
}

function board_delete(select_bno,select_mno,session_mno)
{
	if(session_mno!=null && select_mno != null)
	{
		if(select_mno == session_mno)
		{
			if(confirm("정말 삭제하시겠습니까??")==true)
			{
				$.ajax({
					url:"oneLineDel.do"
					,method:'post'
					,dataType:'text'
					,data:{'bno':select_bno}
					,success:function(data)
					{
						console.log("board_delete 성공");
						location.href="oneLineList.do";
					}
					,error:function(data)
					{
						console.log('error',data);
					}
				});
			}			
		}
		else
		{
			alert("삭제 권한이 없습니다.");
		}
	}
	else
	{
		alert("로그인이 필요합니다.");
		location.href="memberLogin.do";
	}
}


function reply_modify(select_rno,select_mno,session_mno)
{
	if(session_mno!=null && select_mno != null)
	{
		if(select_mno == session_mno)
		{
			console.log("리플 수정 페이지로 이동합니다.");
		}
		else
		{
			alert("수정 권한이 없습니다.");
		}
	}
	else
	{
		alert("로그인이 필요합니다.");
		location.href="memberLogin.do";
	}
}

function reply_delete(select_rno,select_mno,session_mno)
{
	if(session_mno!=null && select_mno != null)
	{
		if(select_mno == session_mno)
		{
			if(confirm("정말 삭제하시겠습니까??")==true)
			{
				$.ajax({
					url:"oneLineRepdel.do"
					,method:'post'
					,dataType:'text'
					,data:{'rno':select_rno}
					,success:function(data)
					{
						console.log("reply_delete 성공");
						location.href="oneLineList.do";
					}
					,error:function(data)
					{
						console.log('error',data);
					}
				});
			}			
		}
		else
		{
			alert("삭제 권한이 없습니다.");
		}
	}
	else
	{
		alert("로그인이 필요합니다.");
		location.href="memberLogin.do";
	}
}
