import React from 'react';
import { connect } from 'react-redux';
import usersActions from 'pages/userList/actions/getUsers'
import { Button, ButtonGroup } from '@material-ui/core';
import Link from 'components/Link';
import * as PAGES from 'constants/pages';

class Users extends React.Component  {
  constructor() {
    super();
    this.state = {
    preProps : ' '  
    }
  }
  componentDidMount(){
    const {
      dispatch,
  } = this.props;
    usersActions.fetchUsers({})(dispatch)
  }
  componentDidUpdate(prevProps, prevState, snapshot) {
    const {
      dispatch,
  } = this.props; 
} 
  render() {
    const {
      dispatch,
      userList,
  } = this.props;
  return (
    <div> 
      
        <h2 className="text-center"> List Users </h2>
            <Link to="/createUser"> Add User </Link>
            <table className="table table-bordered table-striped">
                <thead>
                <tr>
                    <th>Login</th>
                    <th>Email</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                {
                    userList.userlist.map(
                        user =>
                            <tr key={user.id}>
                                <td style={{whiteSpace: 'nowrap'}}>{user.login}</td>
                                <td>{user.email}</td>
                                <td>{user.firstName}</td>
                                <td>{user.lastName}</td>
                             
                                
                                  
                              
                                

                                <Link to={(location => ({
                                    ...location, 
                                    pathname: "/" + PAGES.UPDATEUSER, 
                                    search: '' + location.search + '&id=' + user.id 
                                }))}>
                                  Jopa
                                </Link>
                               
                            </tr>
                    )
                }
                
                </tbody>
            </table>
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