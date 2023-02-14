import { useSelector } from 'react-redux';
import React from 'react';
import UsersPageAccessValidator from 'components/PageAccessValidator/UsersPageAccessValidator'
import UsersPage from 'pages/userList'
import PageContainer from 'components/PageContainer';

const Users = () => {
  const user = useSelector(({ user }) => user);

  return (
    <UsersPageAccessValidator>
      <PageContainer>
        <UsersPage></UsersPage>
      </PageContainer>
    </UsersPageAccessValidator>
    
    )
};

export default Users;