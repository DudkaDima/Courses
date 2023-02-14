import React from 'react';
import { connect } from 'react-redux';
import usersActions from 'pages/userList/actions/getUsers'
import { Button } from '@material-ui/core';

class Users extends React.Component  {
  constructor() {
    super();
    this.state = {
    preProps : ' '  
    }
  }
  componentDidMount(){
    const {
      userList,
      dispatch,
  } = this.props;
  }
  componentDidUpdate(prevProps, prevState, snapshot) {
    const {
      userList,
  } = this.props;
  console.log(userList)
  console.log(userList.userlist[0].firstName)
  console.log(userList.name)
  console.log(userList.isLoading)
} 
  render() {
    const {
      dispatch,
  } = this.props;
  return (
    <div> 
      <Button onClick={() => usersActions.fetchUsers({})(dispatch)}>Pizda</Button>
    </div>
  )
  }
}
  const mapReduxStatetoProps = reduxState => ({
    ...reduxState,
  });
  const mapDispatchToProps = dispatch => ({
    dispatch,
  });
  export default connect(mapReduxStatetoProps, mapDispatchToProps)(Users);