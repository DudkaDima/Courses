import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import { useSelector } from 'react-redux';
import useAccessValidate from 'hooks/useAccessValidate';
import Link from 'components/Link';
import Typography from 'components/Typography';
import { Button } from '@material-ui/core';
import usersActions from 'pages/userList/actions/getUsers'

const getClasses = makeStyles(() => ({
  container: {
    display: 'flex',
    flexDirection: 'column',
  },
}));

const Initial = ({
  authorities,
}) => {
  const classes = getClasses();
  const {
    availableItems,
  } = useSelector(({ reducer })=> reducer);
  const canSeeList = useAccessValidate({
    ownedAuthorities: authorities,
    neededAuthorities: ['МОЖНО_ВОТ_ЭТУ_ШТУКУ'],
  });

  return (
    <div className={classes.container}>
      {canSeeList && availableItems.map((item, index) => (
        
        <Link
          href={index % 2 === 0
            ? `https://www.google.com.ua/search?q=${item}&hl=ru`
            : undefined}
          to={index % 2 !== 0
            ? (location => ({
              ...location,
              pathname: `/${item}`,
              search: `${location.search}&newProp=42`,
            }))
            : undefined}
        >
          <Typography>
            {item}
          </Typography>
        </Link>
         
      ))}
      
      {!canSeeList && (
        <Typography>
          Не могу ничего показать :(
        </Typography>
      )}
      
      <Link
         href={`http://localhost:3000/users?lang=en`} >
       <Typography>
            {'userList'}
          </Typography>
       </Link>
      
     
    </div>
  )
};

export default Initial;
